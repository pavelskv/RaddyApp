package com.shechkov.raddyapp.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.shechkov.raddyapp.MainActivity
import com.shechkov.raddyapp.R
import com.shechkov.raddyapp.core.SimpleTextChangeListener
import com.shechkov.raddyapp.databinding.FragmentLoginBinding
import com.shechkov.raddyapp.ui.base.BaseFragment
import com.shechkov.raddyapp.ui.home.HomeFragment
import com.shechkov.raddyapp.utils.hideKeyboard

class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    FragmentLoginBinding::inflate
) {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val loginViewModel by viewModels<LoginViewModel>({ activity as MainActivity }) { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.bringToFront()

        val emailTextWatcher = object : SimpleTextChangeListener() {
            override fun afterTextChanged(s: Editable?) {
                if (binding.loginTextInputLayout.isErrorEnabled)
                    loginViewModel.clearLoginError()
            }
        }
        binding.loginEditText.addTextChangedListener(emailTextWatcher)

        val passwordTextWatcher = object : SimpleTextChangeListener() {
            override fun afterTextChanged(s: Editable?) {
                if (binding.passwordTextInputLayout.isErrorEnabled)
                    loginViewModel.clearPasswordError()
            }
        }
        binding.passwordEditText.addTextChangedListener(passwordTextWatcher)

        binding.loginButton.setOnClickListener {
            loginViewModel.login(
                binding.loginEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
            hideKeyboard()
        }

        loginViewModel.loginState.observe(viewLifecycleOwner, Observer {
            binding.loginTextInputLayout.isErrorEnabled = it.containsError
            binding.loginTextInputLayout.error = getString(it.errorMessage)
        })

        loginViewModel.passwordState.observe(viewLifecycleOwner, Observer {
            binding.passwordTextInputLayout.isErrorEnabled = it.containsError
            binding.passwordTextInputLayout.error = getString(it.errorMessage)
        })

        loginViewModel.progressState.observe(viewLifecycleOwner, Observer {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            binding.loginButton.isEnabled = !it
        })

        loginViewModel.messageState.observe(viewLifecycleOwner, Observer { login ->
            if (login)
                onLogin()
            else
                Toast.makeText(requireContext(), getString(R.string.wrong_data), Toast.LENGTH_SHORT)
                    .show()
        })
    }

    private fun onLogin() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(HomeFragment::class.simpleName)
            replace<HomeFragment>(R.id.fragment_container_view)
        }
    }


    override fun getViewModel(): Class<LoginViewModel> = LoginViewModel::class.java

}