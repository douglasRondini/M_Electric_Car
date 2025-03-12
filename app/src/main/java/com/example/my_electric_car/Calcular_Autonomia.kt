package com.example.my_electric_car

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.my_electric_car.databinding.ActivityCalcularAutonomiaBinding

class Calcular_Autonomia : AppCompatActivity() {
    private lateinit var binding: ActivityCalcularAutonomiaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCalcularAutonomiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        close()
    }
    private fun close() {
        binding.imgClose.setOnClickListener {
            finish()
        }
    }
}