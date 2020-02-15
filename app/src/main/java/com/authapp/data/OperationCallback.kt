package com.authapp.data

import com.authapp.data.model.LoginResponse

interface OperationCallback {
    fun onCallback(response:LoginResponse)
}