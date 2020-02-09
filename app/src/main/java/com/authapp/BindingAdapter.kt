package com.authapp

import androidx.appcompat.widget.AppCompatEditText

class BindingAdapter {


    @androidx.databinding.BindingAdapter("bind:setError")
    fun setError(view: AppCompatEditText, msg: String?) {
        view.requestFocus()
        view.error = msg
    }
}
