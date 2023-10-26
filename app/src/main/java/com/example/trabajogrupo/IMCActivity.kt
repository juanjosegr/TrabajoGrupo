package com.example.trabajogrupo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class IMCActivity : AppCompatActivity() {

    private var tarjIzq: Boolean = true
    private var tarjDer: Boolean = false
    private lateinit var tarjetaHombre: CardView
    private lateinit var tarjetaFemina: CardView
    private lateinit var barraMedida: RangeSlider
    private lateinit var alturaCM: TextView
    private lateinit var sumarPeso: FloatingActionButton
    private lateinit var restarPeso: FloatingActionButton
    private lateinit var mostrarPeso: TextView
    private lateinit var sumarEdad: FloatingActionButton
    private lateinit var restarEdad: FloatingActionButton
    private lateinit var mostrarEdad: TextView
    private lateinit var btnCalculo: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btnRegresarMenu()
        llamadaDeComponentes()
        pulsacionesDeFunciones()
        calculoIMC()
    }


    private fun llamadaDeComponentes() {
        tarjetaHombre = findViewById(R.id.tarjetaIzquierda)
        tarjetaFemina = findViewById(R.id.tarjetaDerecha)
        barraMedida = findViewById(R.id.BarraDeRango)
        alturaCM = findViewById(R.id.alturaEnCm)
        sumarPeso = findViewById(R.id.btnDePesoMas)
        restarPeso = findViewById(R.id.btnDePesoMenos)
        mostrarPeso = findViewById(R.id.pesoEnKilos)
        sumarEdad = findViewById(R.id.btnDeEdadMas)
        restarEdad = findViewById(R.id.btnDeEdadMenos)
        mostrarEdad = findViewById(R.id.edadEnNumero)
        btnCalculo = findViewById(R.id.btnCalcular)
    }

    private fun botonesVoF() {
        tarjIzq = !tarjIzq
        tarjDer = !tarjDer
    }

    private fun pulsacionesDeFunciones() {
        tarjetaHombre.setOnClickListener {
            cambioDeColor(tarjetaHombre)
            colorStandar(tarjetaFemina)
            botonesVoF()
        }
        tarjetaFemina.setOnClickListener {
            cambioDeColor(tarjetaFemina)
            colorStandar(tarjetaHombre)
            botonesVoF()
        }

        barraMedida.addOnChangeListener { _, value, _ ->
            alturaCM.text = value.toInt().toString()
        }

        sumarPeso.setOnClickListener {
            var valorF = mostrarPeso.text.toString().toInt()
            valorF++
            mostrarPeso.text = valorF.toString()
        }

        restarPeso.setOnClickListener {
            var valorF = mostrarPeso.text.toString().toInt()
            valorF--
            mostrarPeso.text = valorF.toString()
        }

        sumarEdad.setOnClickListener {
            var valorF = mostrarEdad.text.toString().toInt()
            valorF++
            mostrarEdad.text = valorF.toString()
        }

        restarEdad.setOnClickListener {
            var valorF = mostrarEdad.text.toString().toInt()
            valorF--
            mostrarEdad.text = valorF.toString()
        }

        btnCalculo.setOnClickListener {
            calculoIMC()
        }
    }

    private fun cambioDeColor(tarjeta: CardView) {
        val color = ContextCompat.getColor(this, R.color.gClaro);
        tarjeta.setCardBackgroundColor(color)
    }

    private fun colorStandar(tarjeta: CardView) {
        val color = ContextCompat.getColor(this, R.color.gOscuro);
        tarjeta.setCardBackgroundColor(color)
    }


    private fun btnRegresarMenu() {
        val btnRegresar = findViewById<Button>(R.id.btnRegresarIMC)
        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calculoIMC(){
        val IMC = mostrarPeso.toString().toInt() / (alturaCM.toString().toDouble() * alturaCM.toString().toDouble())
        println(IMC)
    }
}