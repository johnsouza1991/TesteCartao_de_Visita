package br.com.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import br.com.businesscard.App
import br.com.businesscard.R
import br.com.businesscard.data.BusinessCard

class AddBusinessCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_business_card)
        insertListener()

        private val mainViewModel : MainViewModel by viewModels{
            MainViewModelFactory((application as App).repository)
        }

    }
    val btsalvar: Button = findViewById(R.id.btSalvar)
    val btclose: ImageButton = findViewById(R.id.bt_close)

    private fun insertListener(){
        btclose.setOnClickListener { finish() }
        btsalvar.setOnClickListener {
        val businessCard = BusinessCard(
            nome = binding.tilNome.editText?.text.toString(),
            empresa = binding.tilEmpresa.editText?.text.toString(),
            telefone = binding.tilTelefone.editText?.text.toString(),
            email = binding.tilEmail.editText?.text.toString(),
            fundoPersonalizado = binding.tilCor.editText?.text.toString(),
        )
            mainViewModel.insert(businessCard)
            Toast.makeText(this,R.string.label_show_sucess,Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}