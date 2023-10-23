package com.jeancasquete.ExamenMoviles_.states

import com.jeancasquete.ExamenMoviles_.models.Mascotas

data class MascotasState(
    val listaUsuarios: List<Mascotas> = emptyList()
)
