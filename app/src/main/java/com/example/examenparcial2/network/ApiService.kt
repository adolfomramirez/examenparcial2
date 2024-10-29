package com.example.examenparcial2.network

import com.example.examenparcial2.models.Estudiante
import retrofit2.http.GET

interface ApiService {
    @GET("estudiantes")
    suspend fun getEstudiantes(): List<Estudiante>
}
