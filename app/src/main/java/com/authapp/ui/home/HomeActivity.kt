package com.authapp.ui.home

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.authapp.R
import com.authapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

   private lateinit var binding: ActivityHomeBinding
    companion object IntentOptions {
        private const val EXTRA_USERNAME = "com.authapp.ui.home.HomeActivity::username"
        var Intent.username: String?
            get() = getStringExtra(EXTRA_USERNAME)
            set(username) {
                putExtra(EXTRA_USERNAME, username)
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.username = intent.username
    }

}
