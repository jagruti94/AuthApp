package com.authapp.data

import com.authapp.data.model.User


data class LoginApiResponse(val status:Int?, val msg:String?, val data: User?){
    fun isSuccess():Boolean= (status==200)
}