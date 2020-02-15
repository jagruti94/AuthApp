package com.authapp.ui.login

import android.app.Application
import android.util.Patterns
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.authapp.R
import com.authapp.data.OperationCallback
import com.authapp.data.model.LoginResponse
import com.authapp.data.repo.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application){

      val userLogin: MutableLiveData<LoginResponse> = MutableLiveData()

      val email = MutableLiveData<String>("")
      val password = MutableLiveData<String>("")

      val validationError=MutableLiveData<LoginErrorEvent>();

      private val loginRepo:LoginRepository=LoginRepository()

    fun login()
    {
        if (email.value!!.isEmpty()) {
            validationError.value=LoginErrorEvent.EMAIL_EMPTY
           return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            validationError.value=LoginErrorEvent.EMAIL_INVALID
            return
        }
        if (password.value!!.isEmpty()) {
            validationError.value=LoginErrorEvent.PASSWORD_EMPTY
             return
        }
        loginRepo.login(email.value!!, password.value!!,object: OperationCallback {
            override fun onCallback(response: LoginResponse) {
                userLogin.value=response
            }
        })
    }

    enum class LoginErrorEvent(@StringRes private val resourceId: Int)  {
        EMAIL_EMPTY(R.string.error_empty_email),
        EMAIL_INVALID(R.string.error_invalid_email),
        PASSWORD_EMPTY(R.string.error_empty_password);
        fun getErrorResource() = resourceId
    }


}