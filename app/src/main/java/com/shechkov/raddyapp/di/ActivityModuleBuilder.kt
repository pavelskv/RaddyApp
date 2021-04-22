package com.shechkov.raddyapp.di

import com.shechkov.raddyapp.MainActivity
import com.shechkov.raddyapp.ui.home.HomeFragment
import com.shechkov.raddyapp.ui.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector()
    abstract fun contributeHomeFragment(): HomeFragment
}