package com.richardson.rotaskotlin.util

import com.richardson.rotaskotlin.model.ResponseMessage
import java.util.Date

class ResponseUtils {
    companion object {
        fun criaResponseMessage(status: Int?, error: String?, message: String?,
                                exceptionClass: String?, path: String?): ResponseMessage? {
            val responseMessage = ResponseMessage()
            responseMessage.setTimestamp(Date(System.currentTimeMillis()))
            responseMessage.setStatus(status)
            responseMessage.setError(error)
            responseMessage.setException(exceptionClass)
            responseMessage.setMessage(message)
            responseMessage.setPath(path)
            return responseMessage
        }
    }
}