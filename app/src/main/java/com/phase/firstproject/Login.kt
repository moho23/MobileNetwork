package com.phase.firstproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.phase.firstproject.databinding.ActivityLoginBinding
import java.util.*
import java.util.regex.Pattern

class Login : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    private val validEmailAddressRegex =
        Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE)

    private fun isValid(emailStr: String): Boolean {
        val matcher = validEmailAddressRegex.matcher(emailStr)
        return matcher.find()
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Login";
        var color = Random();

        binding.googleLogin.setOnClickListener {
            binding.googleLogin.setBackgroundColor(
                Color.argb(
                    255,
                    color.nextInt(255),
                    color.nextInt(255),
                    color.nextInt(255)
                )
            )
        }

        binding.facebookLogin.setOnClickListener {
            binding.facebookLogin.setBackgroundColor(
                Color.argb(
                    255,
                    color.nextInt(255),
                    color.nextInt(255),
                    color.nextInt(255)
                )
            )
        }

        binding.loginEmailEditText.addTextChangedListener { it ->
            if (isValidEmail(it.toString())) {
                binding.loginEmail.isErrorEnabled = false
            } else {
                binding.loginEmail.error = "Wrong email format";
            }
        }

        binding.loginPasswordEditText.addTextChangedListener { text ->
            if (binding.loginPassword.editText?.text?.length != 0) {
                binding.loginPassword.isErrorEnabled = false
            }
        }

        binding.redirectToSignupButton.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

        binding.loginFormButton.setOnClickListener {
            if (binding.loginEmailEditText.length() != 0 && isValidEmail(binding.loginEmail.editText!!.text) && binding.loginPasswordEditText.length() != 0) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            }
            if (binding.loginEmailEditText.length() == 0 && binding.loginPasswordEditText.length() != 0) {
                binding.loginEmail.error = "Enter a valid email to login"
            }
            if (binding.loginEmailEditText.length() != 0 && binding.loginPasswordEditText.length() == 0) {
                binding.loginPassword.error = "Enter a password to login"
            }
            if (binding.loginEmailEditText.length() == 0 && binding.loginPasswordEditText.length() == 0) {
                binding.loginPassword.error = "Enter a password"
                binding.loginEmail.error = "Enter a valid email"
            }
        }
    }
}