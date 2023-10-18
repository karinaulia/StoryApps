package com.bangkit.storyapps.view.signup

import androidx.lifecycle.ViewModel
import com.bangkit.storyapps.data.UserRepository

class SignupViewModel(private val repository: UserRepository) : ViewModel() {
    fun register(name: String, email: String, password: String) = repository.sendRegister(name, email, password)
}