package com.example.appbookinghotel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appbookinghotel.databinding.ActivityMainBinding
import com.example.appbookinghotel.view.SignInActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventHandling()
    }
    private fun eventHandling()
    {
        binding.pageChange.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}