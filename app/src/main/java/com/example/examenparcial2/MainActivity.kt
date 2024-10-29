package com.example.examenparcial2

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenparcial2.adapters.EstudianteAdapter
import com.example.examenparcial2.databinding.ActivityMainBinding
import com.example.examenparcial2.viewmodel.EstudianteViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: EstudianteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.estudiantes.observe(this, { estudiantes ->
            val adapter = EstudianteAdapter(estudiantes) { estudiante ->
                val intent = Intent(this, DetalleEstudianteActivity::class.java)
                intent.putExtra("estudiante", estudiante)
                startActivity(intent)
            }
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = adapter
        })
    }
}
