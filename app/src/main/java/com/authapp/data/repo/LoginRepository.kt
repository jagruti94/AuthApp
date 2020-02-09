package com.authapp.data.repo

import com.authapp.data.LoginApiResponse
import com.authapp.data.OperationCallback
import com.authapp.data.model.User
import com.authapp.network.AuthAppApi
import com.authapp.network.WebServiceClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    /**
     * Makes an API call and returns result in callback.
     */
    fun login(email:String,password:String,callback: OperationCallback)
     {

         //dummy data check as API not available

         if(email == "work.jagruti@gmail.com" && password == "Test@1234")
             callback.onSuccess(User("",email))
         else
             callback.onError("Email address or password is invalid")

         // API call
       /* WebServiceClient.client.create(AuthAppApi::class.java).LOGIN(email,password)
            .enqueue(object :Callback<LoginApiResponse>{
                override fun onResponse(call: Call<LoginApiResponse>?, response: Response<LoginApiResponse>?) {
                    response?.body()?.let {
                        if(response.isSuccessful && (it.isSuccess())){
                            callback.onSuccess(it.data)
                        }else{
                            callback.onError(it.msg)
                        }
                    }
                }
                override fun onFailure(call: Call<LoginApiResponse>?, t: Throwable?)
                { callback.onError(t?.message) }
            })*/
    }

}