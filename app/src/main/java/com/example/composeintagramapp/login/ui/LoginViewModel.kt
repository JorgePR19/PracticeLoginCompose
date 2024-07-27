package com.example.composeintagramapp.login.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    var email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    var password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    var isLoginEnable: LiveData<Boolean> = _isLoginEnable

    fun onLoginChange(email: String, pass:String) {
        _email.value = email
        _password.value = pass
        _isLoginEnable.value = enableLogin(email, pass)
    }

    fun enableLogin(email: String, pass: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            pass.length > 6
}