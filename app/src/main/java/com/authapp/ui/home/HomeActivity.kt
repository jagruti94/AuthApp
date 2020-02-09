package com.authapp.ui.home

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.authapp.R
import com.authapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding?.username = intent.getStringExtra("Username")

    }

}
