package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preco)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val etPreco = findViewById<EditText>(R.id.etPreco)
        val btnProximo = findViewById<Button>(R.id.btnProximo)

        btnProximo.setOnClickListener {
            val preco = etPreco.text.toString()

            if (preco.isNotEmpty()) {
                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra("preco", preco) // Passa o preço para a próxima tela
                startActivity(intent)
            } else {
                etPreco.error = "Digite o preço do combustível!"
            }
        }
    }
}
