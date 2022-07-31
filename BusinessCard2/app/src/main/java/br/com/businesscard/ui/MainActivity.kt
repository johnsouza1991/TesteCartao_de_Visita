package br.com.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import br.com.businesscard.App
import br.com.businesscard.R
import br.com.businesscard.data.BusinessCard

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.rvCards.adapter = adapter
        private val mainViewModel : MainViewModel by viewModels{
            MainViewModelFactory((application as App).repository)
        }

        private val adapter by lazy { BusinessCardAdapter() }
        getAllBusinessCard()
        insertListener()

    }
    val fbadd: Button = findViewById(R.id.fbadd)

    private fun insertListener(){
        fbadd.setOnClickListener {
            val intent = Intent(this@MainActivity,AddBusinessCardActivity::class.java)
            startActivity(intent)

        }
    }

    private fun getAllBusinessCard(){
        mainVielModel.getAll().observe(this,{ businessCards -> adapter.submitList(businessCards)})
    }

}