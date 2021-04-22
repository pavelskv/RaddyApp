package com.shechkov.raddyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.shechkov.raddyapp.ui.base.BaseFragment
import com.shechkov.raddyapp.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(LoginFragment::class.simpleName)
                add<LoginFragment>(R.id.fragment_container_view)
            }
        }
    }
}