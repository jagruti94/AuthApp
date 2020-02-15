package com.authapp.ui.login

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.authapp.R
import com.authapp.databinding.ActivityLoginBinding
import com.authapp.ui.home.HomeActivity

class LoginActivity : AppCompatActivity() {

   private lateinit var binding: ActivityLoginBinding
   private lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewmodel = viewmodel

        viewmodel.validationError.observe(this, Observer { handleError(it)})

        viewmodel.userLogin.observe(this, Observer { response->
            if(response.success){
                val intent = Intent(this, HomeActivity::class.java)
                with(HomeActivity.IntentOptions) {
                    intent.username = response.data
                }
                startActivity(intent)
                finish()
            }
            else
                Toast.makeText(this,response.errMsg,Toast.LENGTH_LONG).show()

        })

    }
    private fun handleError(errorRes:LoginViewModel.LoginErrorEvent) {
        when(errorRes.getErrorResource()){
            R.string.error_empty_email-> binding.emailEt.error = getString(R.string.error_empty_email)
            R.string.error_invalid_email-> binding.emailEt.error = getString(R.string.error_invalid_email)
            R.string.error_empty_password-> binding.passwordEt.error = getString(R.string.error_empty_password)
        }
    }


}
