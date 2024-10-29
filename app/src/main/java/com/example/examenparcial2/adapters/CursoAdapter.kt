package com.example.examenparcial2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenparcial2.R

class CursoAdapter(private val cursos: List<String>) :
    RecyclerView.Adapter<CursoAdapter.CursoViewHolder>() {

    inner class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cursoTextView: TextView = itemView.findViewById(R.id.cursoTextView)

        fun bind(curso: String) {
            cursoTextView.text = curso
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_curso, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        holder.bind(cursos[position])
    }

    override fun getItemCount(): Int = cursos.size
}