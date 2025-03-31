package com.example.my_electric_car

import adapter.AdapterCar
import adapter.TabsAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TableLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.my_electric_car.databinding.ActivityCalcularAutonomiaBinding
import com.example.my_electric_car.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
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
        setupTabs()

    }
    fun setupTabs() {
        val tabsAdapter = TabsAdapter(this)
        binding.viewPage.adapter = tabsAdapter
        clicksTabs()
    }
    fun clicksTabs() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    binding.viewPage.currentItem = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        })
        binding.viewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.getTabAt(position)?.select()
            }
        })
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