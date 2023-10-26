package com.example.trabajogrupo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var botones : ArrayList<Button>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ListaBotones()
        InitBotones()
    }

    /**
     *  Lista donde se guardan los botones del IMC.
     */

    fun ListaBotones(){
            botones = ArrayList()
            botones.add(findViewById<Button>(R.id.calculadoraJuanjo))
            botones.add(findViewById<Button>(R.id.menuImc))
            botones.add(findViewById<Button>(R.id.calculadoraElian))
            botones.add(findViewById<Button>(R.id.calculadoraDani))
            botones.add(findViewById<Button>(R.id.SalirPrograma))
    }

    /**
     *  Se recorre la lista de botones.
     */
    fun InitBotones(){
        for(n in botones.indices){
            botones[n].setOnClickListener {
                Navegacion(n)
            }
        }
    }

    /**
     *  Se indica la funcion a realizar
     *  @param boton indica el número elegido y la función a realizar.
     */
    fun Navegacion(boton: Int){
        when(boton){
            0 -> {
                val intent = Intent(this, MainActivityJuanJo::class.java)
                startActivity(intent)
            }
            1 -> {
                val intent = Intent(this, IMCActivity::class.java)
                startActivity(intent)
            }
            2 -> {
                val intent = Intent(this, MainActivityElian::class.java)
                startActivity(intent)
            }
            3 -> {
                val intent = Intent(this, MainActivity_dani::class.java)
                startActivity(intent)
            }
            4 -> {
                finishAffinity()
                System.exit(0)
            }
        }
    }
}