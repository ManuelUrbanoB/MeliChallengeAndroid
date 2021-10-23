package com.murbanob.melichallenge.domain.helpers

enum class ErrorResult {
    ErrorInNetwork {
        override fun getMessageToUser(): String {
            return MESSAGE_NETWORK
        }
    },
    ErrorInResponse {
        override fun getMessageToUser(): String {
            return MESSAGE_RESPONSE
        }
    },
    ErrorInRequest {
        override fun getMessageToUser(): String {
            return MESSAGE_REQUEST
        }
    },
    UnknownError;

    open fun getException(): Exception = Exception(this.name)
    open fun getMessageToUser(): String = DEFAULT_MESSAGE

    companion object {
        private const val DEFAULT_MESSAGE = "Error in your request, please try again"
        private const val MESSAGE_NETWORK =
            "Error in your network connection, please verify your connection"
        private const val MESSAGE_RESPONSE = "Error to get the information, please try again"
        private const val MESSAGE_REQUEST =
            "Error in the request of the information, please try again"

        fun getException(exception: Exception): ErrorResult {
            return values().firstOrNull { it.name == exception.message } ?: UnknownError
        }

    }
}