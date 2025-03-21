package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distancia)

        val etDistancia = findViewById<EditText>(R.id.etDistancia)
        val btnProximo = findViewById<Button>(R.id.btnProximo)

        val preco = intent.getStringExtra("preco")
        val consumo = intent.getStringExtra("consumo")

        btnProximo.setOnClickListener {
            val distancia = etDistancia.text.toString()

            if (distancia.isNotEmpty()) {
                val intent = Intent(this, ResultadosActivity::class.java)
                intent.putExtra("preco", preco)
                intent.putExtra("consumo", consumo)
                intent.putExtra("distancia", distancia) // Passa a distância para a tela final
                startActivity(intent)
            } else {
                etDistancia.error = "Digite a distância!"
            }
        }
    }
}
