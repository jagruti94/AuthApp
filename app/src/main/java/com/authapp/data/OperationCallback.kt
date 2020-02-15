package com.authapp.data

import com.authapp.data.model.Response

interface OperationCallback {
    fun onCallback(response:Response<String>)
}