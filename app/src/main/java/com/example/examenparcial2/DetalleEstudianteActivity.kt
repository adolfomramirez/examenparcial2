package com.example.examenparcial2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.examenparcial2.databinding.ActivityDetalleEstudianteBinding
import com.example.examenparcial2.models.Estudiante
import com.squareup.picasso.Picasso

class DetalleEstudianteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetalleEstudianteBinding = DataBindingUtil.setContentView(this, R.layout.activity_detalle_estudiante)

        val estudiante = intent.getParcelableExtra<Estudiante>("estudiante")
        binding.estudiante = estudiante

        Picasso.get().load(estudiante?.fotoPerfil).into(binding.fotoImageView)
    }
}
