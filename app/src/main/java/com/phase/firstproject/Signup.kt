package com.phase.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.phase.firstproject.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {

    private var _binding: ActivitySignupBinding? = null
    private val binding get() = _binding!!

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        _binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Signup";

        binding.redirectToLoginButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.backToLoginButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        binding.signupEmailEditText.addTextChangedListener { it ->
            if (isValidEmail(it.toString())) {
                binding.signupEmail.isErrorEnabled = false
            } else {
                binding.signupEmail.error = "Wrong email format";
            }
        }

        binding.signupPasswordEditText.addTextChangedListener { text ->
            if (binding.signupPassword.editText?.text?.length != 0) {
                binding.signupPassword.isErrorEnabled = false
            }
        }

        binding.signupConfirmPasswordEditText.addTextChangedListener { text ->
            if (binding.signupConfirmPasswordEditText.text.toString() == binding.signupPasswordEditText.text.toString()) {
                binding.signupConfirmPassword.isErrorEnabled = false
            } else {
                binding.signupConfirmPassword.error = "password mismatch"
            }
        }

        binding.signupFullNameEditText.addTextChangedListener { text ->
            if (binding.signupFullName.editText?.text?.length != 0) {
                binding.signupFullName.isErrorEnabled = false
            }
        }

        binding.phoneNumberEditText.addTextChangedListener { text ->
            if (text?.length == 11) {
                binding.signupPhoneNumber.isErrorEnabled = false
            } else {
                binding.signupPhoneNumber.error = "Phone number is short"
            }
        }

        binding.signupCreateButton.setOnClickListener {
            if (binding.phoneNumberEditText.length() == 0 && binding.signupConfirmPasswordEditText.length() == 0 && binding.signupPasswordEditText.length() == 0 && binding.signupEmailEditText.length() == 0 && binding.signupFullNameEditText.length() == 0) {
                binding.signupPassword.error = "Enter password"
                binding.signupConfirmPassword.error = "Re-enter password"
                binding.signupPhoneNumber.error = "Enter a valid phone number"
                binding.signupFullName.error = "Enter your full name"
                binding.signupEmail.error = "Enter a valid email"
            }
            if (binding.phoneNumberEditText.length() != 0 && binding.signupConfirmPasswordEditText.length() != 0 && binding.signupPasswordEditText.length() != 0 && binding.signupEmailEditText.length() != 0 && isValidEmail(binding.signupEmail.editText!!.text) && binding.signupFullNameEditText.length() != 0) {
                Toast.makeText(this, "User Created", Toast.LENGTH_LONG).show()
            }
        }
    }
}