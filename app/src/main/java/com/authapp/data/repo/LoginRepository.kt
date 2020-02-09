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

    fun login(email:String,password:String,callback: OperationCallback)
     {

             callback.onSuccess(User("",email)) //returning dummy data as API not available

         //  callback.onError("Something went wrong.Please try again")

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
            })
*/
    }

}