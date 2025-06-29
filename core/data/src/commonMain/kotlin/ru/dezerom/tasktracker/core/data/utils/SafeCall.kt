package ru.dezerom.tasktracker.core.data.utils

import com.diamondedge.logging.logging
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
    call: suspend () -> ResponseDto<T?>
): Result<T> = withContext(dispatcher) {
    try {
        val result = call()
        if (result.success) {
            if (result.body != null)
                Result.success(result.body)
            else
                Result.failure(NetworkError(Res.string.err_unknown_error.wrapInContainer()))
        } else {
            val err = result.error
            val errorMessage = err?.wrapInContainer()
                ?: Res.string.err_unknown_error.wrapInContainer()

            Result.failure(NetworkError(errorMessage))
        }
    } catch (e: Exception) {
        log.e(err = e, msg = { e.message })

        if (e is HttpException) {
            if (e.code() == 401) {
                return@withContext Result.failure(NetworkError.unauthorizedNetworkError())
            }
        }

        Result.failure(NetworkError.unknownNetworkError())
    }
}