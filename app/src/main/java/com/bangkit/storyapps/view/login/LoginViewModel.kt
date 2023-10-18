package com.bangkit.storyapps.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.storyapps.data.UserRepository
import com.bangkit.storyapps.data.pref.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun login(email: String, password: String) = repository.sendLogin(email, password)
}