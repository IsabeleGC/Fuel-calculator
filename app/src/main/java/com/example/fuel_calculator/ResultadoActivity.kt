package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultadoTextView = findViewById<TextView>(R.id.tvResultado)
        val precoValorTextView = findViewById<TextView>(R.id.tvPrecoValor)
        val consumoValorTextView = findViewById<TextView>(R.id.tvConsumoValor)
        val kmValorTextView = findViewById<TextView>(R.id.tvKmValor)
        val novoCalculoButton = findViewById<Button>(R.id.btnNovoCalculo)

        val distancia = intent.getStringExtra("distancia")?.toDoubleOrNull() ?: 0.0
        val consumo = intent.getStringExtra("consumo")?.toDoubleOrNull() ?: 0.0
        val preco = intent.getStringExtra("preco")?.toDoubleOrNull() ?: 0.0

        val gastoTotal = if (consumo > 0) (distancia / consumo) * preco else 0.0

        // Usa Locale para Portugal
        val formatoMoeda = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-PT"))

        resultadoTextView.text = formatoMoeda.format(gastoTotal)
        precoValorTextView.text = formatoMoeda.format(preco)
        consumoValorTextView.text = formatoMoeda.format(consumo)
        kmValorTextView.text = formatoMoeda.format(distancia)

        novoCalculoButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
