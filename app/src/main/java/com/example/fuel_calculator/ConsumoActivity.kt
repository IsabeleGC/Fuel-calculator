package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consumo)

        val etConsumo = findViewById<EditText>(R.id.etConsumo)
        val btnProximo = findViewById<Button>(R.id.btnProximo)

        val preco = intent.getStringExtra("preco") // Recupera o preço

        btnProximo.setOnClickListener {
            val consumo = etConsumo.text.toString()

            if (consumo.isNotEmpty()) {
                val intent = Intent(this, DistanciaActivity::class.java)
                intent.putExtra("preco", preco)
                intent.putExtra("consumo", consumo) // Passa o consumo para a próxima tela
                startActivity(intent)
            } else {
                etConsumo.error = "Digite o consumo do carro!"
            }
        }
    }
}
