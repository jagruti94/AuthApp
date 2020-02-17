package com.authapp.data.model

data class Response<T>(val data: T?, val success:Boolean, val errMsg:String?)