package com.authapp.data.repo

import com.authapp.data.OperationCallback
import com.authapp.data.model.LoginResponse

class LoginRepository {

    fun login(email:String,password:String,callback: OperationCallback)
     {
         //dummy data check
         if(email == "work.jagruti@gmail.com" && password == "Test@1234")
             callback.onCallback(LoginResponse(email,true,null))
         else
             callback.onCallback(LoginResponse(null,false,"Email address or password is invalid"))

    }

}