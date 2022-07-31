package br.com.businesscard

import android.app.Application
import br.com.businesscard.data.AppDataBase
import br.com.businesscard.data.BusinessCardRepository

class App: Application() {

    val database by lazy{AppDataBase.getDatabase(this)}
    val repository by lazy{BusinessCardRepository(database.businessDao())}


}