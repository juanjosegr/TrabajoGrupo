package com.example.trabajogrupo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class IMCActivity: AppCompatActivity() {

    private var tarjIzq: Boolean = true
    var tarjDer: Boolean = false
    private lateinit var tarjetaHombre: CardView
    private lateinit var tarjetaFemina: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btnRegresarMenu()
        llamadaDeComponentes()
        pulsacionesDeFunciones()
        botonesVoF()


    }

    private fun llamadaDeComponentes(){
        tarjetaHombre = findViewById(R.id.tarjetaIzquierda)
        tarjetaFemina = findViewById(R.id.tarjetaDerecha)
    }

    private fun botonesVoF(){
        tarjIzq = !tarjIzq
        tarjDer = !tarjDer
    }

    private fun pulsacionesDeFunciones(){
        tarjetaHombre.setOnClickListener{
            cambioDeColor(tarjetaHombre)
            colorStandar(tarjetaFemina)
        }
        tarjetaFemina.setOnClickListener{
            cambioDeColor(tarjetaFemina)
            colorStandar(tarjetaHombre)
        }
    }

    private fun cambioDeColor(tarjeta: CardView){
        val color = ContextCompat.getColor(this, R.color.gClaro);
        tarjeta.setCardBackgroundColor(color)
    }

    private fun colorStandar(tarjeta: CardView) {
        val color = ContextCompat.getColor(this, R.color.gOscuro);
        tarjeta.setCardBackgroundColor(color)
    }


        private fun btnRegresarMenu(){
        val btnRegresar = findViewById<Button>(R.id.btnRegresarIMC)
        btnRegresar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }
    }
}