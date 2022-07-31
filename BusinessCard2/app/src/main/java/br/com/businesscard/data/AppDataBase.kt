package br.com.businesscard.data

import android.content.Context
import androidx.room.Database

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDataBase : RoomDataBase() {
    abstract fun businessDao() : BusinessCardDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase?= null
        fun getDatabase(context : Context): AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    name:"businesscard_db"

                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}