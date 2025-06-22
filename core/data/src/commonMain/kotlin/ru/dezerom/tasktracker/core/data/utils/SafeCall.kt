package ru.dezerom.tasktracker.core.data.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import ru.dezerom.tasktracker.core.data.models.ResponseDto

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
                Result.failure(NetworkError(R.string.unknown_error.toStringContainer()))
        } else {
            val err = result.error
            val errorMessage = err?.toStringContainer()
                ?: R.string.unknown_error.toStringContainer()

            Result.failure(NetworkError(errorMessage))
        }
    } catch (e: Exception) {
        Timber.e(e)

        if (e is HttpException) {
            if (e.code() == 401) {
                return@withContext Result.failure(unAuthorizedNetworkError())
            }
        }

        Result.failure(unknownNetworkError())
    }
}