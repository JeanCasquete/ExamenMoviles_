package com.jeancasquete.ExamenMoviles_.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeancasquete.ExamenMoviles_.models.Mascotas
import com.jeancasquete.ExamenMoviles_.room.MascotasDatabaseDao
import com.jeancasquete.ExamenMoviles_.states.MascotasState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MascotasViewModel(
    private val dao: MascotasDatabaseDao
): ViewModel() {

    var state by mutableStateOf(MascotasState())
        private set


    init {
        viewModelScope.launch {
            dao.obtenerUsuarios().collectLatest {
                state = state.copy(
                    listaUsuarios = it
                )
            }
        }
    }

    fun agregarUsuario(mascota: Mascotas) = viewModelScope.launch {
        dao.agregarUsuario(mascota = mascota)

    }

    fun borrarUsuario(mascota: Mascotas) = viewModelScope.launch {
        dao.borrarUsuario(mascota = mascota)
    }

}