package com.authapp.ui.login

import android.app.Application
import android.util.Patterns
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.authapp.R
import com.authapp.data.OperationCallback
import com.authapp.data.model.User
import com.authapp.data.repo.LoginRepository

class LoginViewModel(application: Application) : AndroidViewModel(application){
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var error_msg_email: ObservableField<String>? = null
    var error_msg_pass: ObservableField<String>? = null
    var userLogin: MutableLiveData<User>? = null
    var errLogin:MutableLiveData<String>?=null
    val loginRepo:LoginRepository=LoginRepository()

    init {
        email = ObservableField("")
        password = ObservableField("")
        error_msg_email= ObservableField()
        error_msg_pass= ObservableField()
        userLogin = MutableLiveData()
        errLogin=MutableLiveData()
    }



    fun login()
    {
        if (email?.get()!!.length==0  ) {
            error_msg_email!!.set(null)
            error_msg_email!!.set(getApplication<Application>().resources.getString(R.string.error_empty_email))
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email?.get()).matches()){
            error_msg_email!!.set(null)
            error_msg_email!!.set(getApplication<Application>().resources.getString(R.string.error_invalid_email))
            return
        }
        if (password?.get()!!.length==0) {
            error_msg_pass!!.set(null)
            error_msg_pass!!.set(getApplication<Application>().resources.getString(R.string.error_empty_password))
            return
        }
        loginRepo.login(email?.get()!!, password?.get()!!,object: OperationCallback {
            override fun onError(obj: Any?) {
                errLogin?.value=obj as String
            }
            override fun onSuccess(obj: Any?) {
                if(obj!=null && obj is User)
                    userLogin?.value = obj

            }
        })
    }




}