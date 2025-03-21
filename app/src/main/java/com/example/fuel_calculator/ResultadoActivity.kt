package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val distancia = intent.getStringExtra("distancia")?.toDoubleOrNull() ?: 0.0
        val consumo = intent.getStringExtra("consumo")?.toDoubleOrNull() ?: 0.0
        val preco = intent.getStringExtra("preco")?.toDoubleOrNull() ?: 0.0

        val gastoTotal = if (consumo > 0) (distancia / consumo) * preco else 0.0

        findViewById<TextView>(R.id.tvResultado).text = "Gasto Total: €${"%.2f".format(gastoTotal)}"

        findViewById<Button>(R.id.btnNovoCalculo).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
