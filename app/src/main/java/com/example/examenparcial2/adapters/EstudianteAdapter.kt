package com.example.examenparcial2.adapters

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial2.R
import com.example.examenparcial2.models.Estudiante

class EstudianteAdapter(private val estudiantes: List<Estudiante>, private val onClick: (Estudiante) -> Unit) :
    RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder>() {

    inner class EstudianteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numeroTextView: TextView = itemView.findViewById(R.id.numeroTextView)
        private val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        private val irButton: Button = itemView.findViewById(R.id.irButton)
        private val fotoImageView: ImageView = itemView.findViewById(R.id.fotoImageView)

        fun bind(estudiante: Estudiante, position: Int) {
            numeroTextView.text = (position + 1).toString()
            nombreTextView.text = "${estudiante.primerNombre} ${estudiante.primerApellido}"
            irButton.setOnClickListener { onClick(estudiante) }

            // Decodificar la imagen Base64 y mostrarla
            val imageBytes = Base64.decode(estudiante.fotoPerfil.split(",")[1], Base64.DEFAULT)
            val imageBitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            fotoImageView.setImageBitmap(imageBitmap)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstudianteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_estudiante, parent, false)
        return EstudianteViewHolder(view)
    }

    override fun onBindViewHolder(holder: EstudianteViewHolder, position: Int) {
        holder.bind(estudiantes[position], position)
    }

    override fun getItemCount(): Int = estudiantes.size
}
