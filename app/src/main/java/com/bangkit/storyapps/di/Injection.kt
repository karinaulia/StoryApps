package com.bangkit.storyapps.di

import android.content.Context
import com.bangkit.storyapps.data.UserRepository
import com.bangkit.storyapps.data.api.ApiConfig
import com.bangkit.storyapps.data.pref.UserPreference
import com.bangkit.storyapps.data.pref.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return UserRepository.getInstance(pref, apiService)
    }
}