package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)

        // Ao clicar no botão, vai para a tela de Preço
        btnIniciar.setOnClickListener {
            val intent = Intent(this, PrecoActivity::class.java)
            startActivity(intent)
        }
    }
}
