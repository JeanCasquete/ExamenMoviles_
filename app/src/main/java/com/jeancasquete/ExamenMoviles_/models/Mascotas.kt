package com.jeancasquete.ExamenMoviles_.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mascotas")
data class Mascotas(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("raza")
    val raza: String,
    @ColumnInfo("color")
    val color: String,
    @ColumnInfo("edad")
    val edad: String

)
