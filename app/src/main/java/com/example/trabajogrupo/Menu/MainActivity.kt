package com.example.trabajogrupo.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.trabajogrupo.Dani.MainActivity_dani
import com.example.trabajogrupo.Elian.MainActivityElian
import com.example.trabajogrupo.IMC.IMCActivity
import com.example.trabajogrupo.Juanjo.MainActivityJuanJo
import com.example.trabajogrupo.R

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
     *  Recorre la lista de botones y se obtiene la dirección del botón pulsado.
     */
    fun InitBotones(){
        for(n in botones.indices){
            botones[n].setOnClickListener {
                Navegacion(n)
            }
        }
    }

    /**
     *  Dependiendo del valor del parámetro, abre una Activity o sale del programa
     *  @param boton indica el número elegido y la función a realizar.
     */
    fun Navegacion(boton: Int){
        when(boton){
            // Abre la Activity de la calculadora de Juango.
            0 -> {
                val intent = Intent(this, MainActivityJuanJo::class.java)
                startActivity(intent)
            }
            // Abre la Activity de la calculadora IMC.
            1 -> {
                val intent = Intent(this, IMCActivity::class.java)
                startActivity(intent)
            }
            // Abre la Activity de la calculadora de Elian.
            2 -> {
                val intent = Intent(this, MainActivityElian::class.java)
                startActivity(intent)
            }
            // Abre la Activity de la calculadora de Daniel.
            3 -> {
                val intent = Intent(this, MainActivity_dani::class.java)
                startActivity(intent)
            }
            // Sale de la aplicación.
            4 -> {
                finishAffinity()
                System.exit(0)
            }
        }
    }
}