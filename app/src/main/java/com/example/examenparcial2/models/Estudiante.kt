package com.example.examenparcial2.models

import android.os.Parcel
import android.os.Parcelable

data class Estudiante(
    val id: Int,
    val primerNombre: String,
    val segundoNombre: String?,
    val primerApellido: String,
    val segundoApellido: String,
    val carrera: String,
    val numeroCarnet: String,
    val sede: String,
    val jornada: String,
    val fotoPerfil: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(primerNombre)
        parcel.writeString(segundoNombre)
        parcel.writeString(primerApellido)
        parcel.writeString(segundoApellido)
        parcel.writeString(carrera)
        parcel.writeString(numeroCarnet)
        parcel.writeString(sede)
        parcel.writeString(jornada)
        parcel.writeString(fotoPerfil)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Estudiante> {
        override fun createFromParcel(parcel: Parcel): Estudiante {
            return Estudiante(parcel)
        }

        override fun newArray(size: Int): Array<Estudiante?> {
            return arrayOfNulls(size)
        }
    }
}
