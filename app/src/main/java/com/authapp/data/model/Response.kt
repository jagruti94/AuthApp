package com.authapp.data.model

data class Response<out T>(val data: T?, val success:Boolean, val errMsg:String?)