package com.example.examenparcial2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenparcial2.models.Estudiante
import com.example.examenparcial2.network.RetrofitInstance
import kotlinx.coroutines.launch

class EstudianteViewModel : ViewModel() {
    private val _estudiantes = MutableLiveData<List<Estudiante>>()
    val estudiantes: LiveData<List<Estudiante>> get() = _estudiantes

    init {
        fetchEstudiantes()
    }

    private fun fetchEstudiantes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getEstudiantes()
                _estudiantes.postValue(response)
            } catch (e: Exception) {
                // Manejar error
            }
        }
    }
}
