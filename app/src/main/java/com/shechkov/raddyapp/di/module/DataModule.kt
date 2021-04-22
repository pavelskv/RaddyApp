package com.shechkov.raddyapp.di.module

import com.shechkov.raddyapp.data.login.LoginRepositoryImpl
import com.shechkov.raddyapp.domain.login.LoginInteractor
import com.shechkov.raddyapp.domain.login.LoginInteractorImpl
import com.shechkov.raddyapp.domain.login.LoginRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideLoginInteractor(loginInteractorImpl: LoginInteractorImpl): LoginInteractor

    @Binds
    @Singleton
    abstract fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}