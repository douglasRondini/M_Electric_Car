package com.example.my_electric_car

import android.os.Bundle
import android.widget.Toast
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
        clickCalcular()
    }
    private fun close() {
        binding.imgClose.setOnClickListener {
            finish()
        }
    }
    private fun result() {
        val preço = binding.edtPreOKwh.text.toString()
        val kmPercorrido = binding.edtKmPercorrido.text.toString()
        val autonimia =  preço.toDouble() / kmPercorrido.toDouble()
        if (preço.isEmpty() || kmPercorrido.isEmpty())
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        else autonimia
        binding.txtResult.text = "$autonimia"
    }


    private fun clickCalcular() {
        binding.btnCalcular.setOnClickListener{
            result()
            finish()
        }
    }
}