package com.jeancasquete.ExamenMoviles_.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jeancasquete.ExamenMoviles_.models.Mascotas

@Database(
    entities = [Mascotas::class],
    version = 2,
    exportSchema = false
)
abstract class MascotasDatabase: RoomDatabase() {
    abstract fun usuariosDao(): MascotasDatabaseDao
}