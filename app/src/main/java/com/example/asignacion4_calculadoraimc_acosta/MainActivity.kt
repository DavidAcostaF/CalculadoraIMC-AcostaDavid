package com.example.asignacion4_calculadoraimc_acosta

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val weight : EditText = findViewById(R.id.weight)
        val height : EditText = findViewById(R.id.height)
        val calculateButton: Button =  findViewById(R.id.btnCalcular)
        val imc: TextView = findViewById(R.id.imc)
        val range:TextView = findViewById(R.id.range)

        calculateButton.setOnClickListener{
            val userIMC = weight.text.toString().toFloat() / (height.text.toString().toFloat() * height.text.toString().toFloat())
            if(userIMC<18.5){
                range.text = "Bajo peso"
            }else if(userIMC in 18.5..24.9){
                range.text = "Normal"
            }else if(userIMC in 25.0..29.9){
                range.text = "Sobrepeso"
            }else if(userIMC in 30.0..34.9){
                range.text = "Obesidad grado 1"
            }else if(userIMC in 35.0..39.9){
                range.text = "Obesidad grado 2"
            }else if(userIMC>= 40){
                range.text = "Obesidad grado 3"
            }
            imc.text = String.format(Locale.getDefault(), "IMC: %.2f", userIMC)

        }
    }
}