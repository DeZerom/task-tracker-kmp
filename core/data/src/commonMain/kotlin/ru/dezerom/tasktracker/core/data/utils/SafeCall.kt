package ru.dezerom.tasktracker.core.data.utils

import com.diamondedge.logging.logging
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.dezerom.tasktracker.core.data.models.ResponseDto
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.err_unknown_error
import ru.dezerom.tasktracker.core.tools.customErrors.NetworkError
import ru.dezerom.tasktracker.core.tools.stringContainer.wrapInContainer

private val log = logging("safeCall")

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    call: suspend () -> HttpResponse
): Result<T> = withContext(dispatcher) {
    try {
        val result = call()
        val statusCode = result.status
        val resp = result.body<ResponseDto<T?>>()

        if (statusCode == HttpStatusCode.Unauthorized) {
            return@withContext Result.failure(NetworkError.unauthorizedNetworkError())
        }

        if (resp.success) {
            if (resp.body != null)
                Result.success(resp.body)
            else
                Result.failure(NetworkError(Res.string.err_unknown_error.wrapInContainer()))
        } else {
            val err = resp.error
            val errorMessage = err?.wrapInContainer()
                ?: Res.string.err_unknown_error.wrapInContainer()

            Result.failure(NetworkError(errorMessage))
        }
    } catch (e: Exception) {
        log.e(err = e, msg = { e.message })

        Result.failure(NetworkError.unknownNetworkError())
    }
}