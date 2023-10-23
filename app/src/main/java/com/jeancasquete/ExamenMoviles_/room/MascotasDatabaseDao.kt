package com.jeancasquete.ExamenMoviles_.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jeancasquete.ExamenMoviles_.models.Mascotas
import kotlinx.coroutines.flow.Flow

@Dao
interface MascotasDatabaseDao {

    @Query("SELECT * FROM mascotas")
    fun obtenerUsuarios(): Flow<List<Mascotas>>

    @Query("SELECT * FROM mascotas WHERE id = :id")
    fun obtenerUsuario(id: Int): Flow<Mascotas>

    @Insert
    suspend fun agregarUsuario(mascota: Mascotas)

    @Update
    suspend fun actualizarUsuario(mascota: Mascotas)

    @Delete
    suspend fun borrarUsuario(mascota: Mascotas)

}