package com.example.trabajogrupo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navegarCalculadoraJuanjo()
        navegarCalculadoraIMC()
        navegarCalculadoraElian()
        navegarCalculadoraDani()
        Salir()
    }

    /**
     * Funcion creada para ir a una calculadora en específico.
     */

    fun navegarCalculadoraJuanjo(){
        val btnCalculadoraJuanjo = findViewById<Button>(R.id.calculadoraJuanjo)
        btnCalculadoraJuanjo.setOnClickListener{
        val intent = Intent(this, MainActivityJuanJo::class.java)
        startActivity(intent)
        }
    }


    fun navegarCalculadoraIMC(){
        val btnCalculadoraImc = findViewById<Button>(R.id.menuImc)
        btnCalculadoraImc.setOnClickListener{
            val intent = Intent(this, IMCActivity::class.java)
            startActivity(intent)
        }
    }


    fun navegarCalculadoraElian(){
        val btnCalculadoraImc = findViewById<Button>(R.id.calculadoraElian)
        btnCalculadoraImc.setOnClickListener{
            val intent = Intent(this, MainActivityElian::class.java)
            startActivity(intent)
        }
    }

    fun navegarCalculadoraDani(){
        val btnCalculadoraImc = findViewById<Button>(R.id.calculadoraDani)
        btnCalculadoraImc.setOnClickListener{
            val intent = Intent(this, MainActivity_dani::class.java)
            startActivity(intent)
        }
    }

    fun Salir(){
        val btnCalculadoraImc = findViewById<Button>(R.id.SalirPrograma)
        btnCalculadoraImc.setOnClickListener{
            finishAffinity()
            System.exit(0)
        }
    }
}