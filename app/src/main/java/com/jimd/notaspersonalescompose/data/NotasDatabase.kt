package com.jimd.notaspersonalescompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jimd.notaspersonalescompose.util.DateConverter
@Database(entities = [NotasEntity::class,EtiquetasEntity::class],
    version = 1,
    exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class NotasDatabase : RoomDatabase(){
    abstract fun notasDao():NotasDao
}