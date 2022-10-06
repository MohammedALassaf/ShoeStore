package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentLoginPageBinding


class LoginPage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val binding: FragmentLoginPageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login_page, container, false
        )
        binding.LoginButton.setOnClickListener { view: View ->
            if (TextUtils.isEmpty(binding.EmailID.text) or TextUtils.isEmpty(binding.passwordText.text)){
                Toast.makeText(this.context, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
                }
            else {
                Navigation.findNavController(view).navigate(R.id.action_loginPage_to_welcomeFragment)
            }

        }

        binding.signUpButton.setOnClickListener{view: View ->
            if (TextUtils.isEmpty(binding.EmailID.text) or TextUtils.isEmpty(binding.passwordText.text)){
                Toast.makeText(this.context, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
            }
            else {
                Navigation.findNavController(view).navigate(R.id.action_loginPage_to_welcomeFragment)
            }

        }

        return binding.root

    }


}