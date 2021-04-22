package com.shechkov.raddyapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.net.Network
import com.shechkov.raddyapp.App
import com.shechkov.raddyapp.data.login.TestApiHelper

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Executors

import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideCoroutineContext(): CoroutineContext = Dispatchers.IO

    @Provides
    @Singleton
    fun provideTestApiHelper(): TestApiHelper = TestApiHelper()

}