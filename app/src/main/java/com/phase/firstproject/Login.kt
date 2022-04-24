package com.phase.firstproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.phase.firstproject.databinding.ActivityLoginBinding
import java.util.*

class Login : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "MobileNetwork-Login";
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

        binding.loginEmailEditText.doAfterTextChanged {

        }
    }
}