package br.com.businesscard.data
import android.view.KeyEvent
import kotlinx.coroutines.*

class BusinessCardRepository ( private val dao: BusinessCardDao){

    fun insert (businessCard: BusinessCard) = runBlocking {
        Launch(Dispatchers.IO){
            dao.insert(businessCard)
        }
    }
    fun getAll()= dao.getAll()

}