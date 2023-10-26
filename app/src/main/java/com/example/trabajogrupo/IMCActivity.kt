package com.example.trabajogrupo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider

class IMCActivity: AppCompatActivity() {

    private var tarjIzq: Boolean = true
    var tarjDer: Boolean = false
    private lateinit var tarjetaHombre: CardView
    private lateinit var tarjetaFemina: CardView
    private lateinit var barraMedida: RangeSlider
    private lateinit var alturaCM: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btnRegresarMenu()
        llamadaDeComponentes()
        pulsacionesDeFunciones()

    }


    private fun llamadaDeComponentes(){
        tarjetaHombre = findViewById(R.id.tarjetaIzquierda)
        tarjetaFemina = findViewById(R.id.tarjetaDerecha)
        barraMedida = findViewById(R.id.BarraDeRango)
        alturaCM = findViewById(R.id.alturaEnCm)
    }

    private fun botonesVoF(){
        tarjIzq = !tarjIzq
        tarjDer = !tarjDer
    }

    private fun pulsacionesDeFunciones(){
        tarjetaHombre.setOnClickListener{
            cambioDeColor(tarjetaHombre)
            colorStandar(tarjetaFemina)
            botonesVoF()
        }
        tarjetaFemina.setOnClickListener{
            cambioDeColor(tarjetaFemina)
            colorStandar(tarjetaHombre)
            botonesVoF()
        }

        barraMedida.addOnChangeListener { _, value, _ ->
            alturaCM.text = value.toInt().toString()
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