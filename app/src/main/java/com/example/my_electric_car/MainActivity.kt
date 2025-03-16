package com.example.my_electric_car

import adapter.AdapterCar
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my_electric_car.databinding.ActivityCalcularAutonomiaBinding
import com.example.my_electric_car.databinding.ActivityMainBinding
import model.InfoCar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var listCar: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        calcularAutonomia()
        listCar()

    }

    fun listCar(){
        listCar = binding.rcvRecyclerview
        val dados = DadosCar().list
        val adapter = AdapterCar(this,dados)
        listCar.layoutManager = LinearLayoutManager(this)
        listCar.adapter = adapter

    }


    private fun calcularAutonomia() {
        binding.btnCalcularAutonomia.setOnClickListener{
            startActivity(Intent(this, Calcular_Autonomia()::class.java))
        }
    }
}