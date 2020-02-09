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

    var binding: ActivityLoginBinding? = null
    var viewmodel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding?.viewmodel = viewmodel
        initObservables()

    }
    private fun initObservables() {
        viewmodel?.userLogin?.observe(this, Observer { user ->
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("Username", user?.name)
            startActivity(intent)
            finish()
        })
        viewmodel?.errLogin?.observe(this, Observer { msg->
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
        })
    }


}
