package com.example.appbookinghotel.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appbookinghotel.R
import com.example.appbookinghotel.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventHandling()
    }
    private fun eventHandling()
    {
        binding.iconBack.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

    }
}