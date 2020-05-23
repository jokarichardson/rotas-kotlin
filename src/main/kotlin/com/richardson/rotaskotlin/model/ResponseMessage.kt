package com.richardson.rotaskotlin.model

import java.util.Date

class ResponseMessage {
    private var timestamp: Date? = null
    private var status: Int? = null
    private var error: String? = null
    private var exception: String? = null
    private var message: String? = null
    private var path: String? = null

    fun getTimestamp(): Date? {
        return timestamp
    }

    fun setTimestamp(timestamp: Date?) {
        this.timestamp = timestamp
    }

    fun getStatus(): Int? {
        return status
    }

    fun setStatus(status: Int?) {
        this.status = status
    }

    fun getError(): String? {
        return error
    }

    fun setError(error: String?) {
        this.error = error
    }

    fun getException(): String? {
        return exception
    }

    fun setException(exception: String?) {
        this.exception = exception
    }

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getPath(): String? {
        return path
    }

    fun setPath(path: String?) {
        this.path = path
    }

}