package com.example.trabajogrupo.IMC

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.trabajogrupo.Menu.MainActivity
import com.example.trabajogrupo.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

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
    private lateinit var btnRegresar: Button

    companion object{
        var IMC_export: String = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        llamadaDeComponentes()
        pulsacionesDeFunciones()

    }


    /**
     * Esta función se encarga de inicializar y asignar los elementos de la interfaz de usuario
     * a las variables correspondientes en la actividad actual.
     */
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
        btnRegresar = findViewById(R.id.btnRegresarIMC)
    }

    /**
     * Esta función asigna manejadores de eventos a diferentes elementos de la interfaz de usuario
     * para llevar a cabo diversas acciones cuando se realizan pulsaciones o cambios.
     */
    private fun pulsacionesDeFunciones() {

        // Pulsación en la tarjeta para hombre
        tarjetaHombre.setOnClickListener {
            cambioDeColor(tarjetaHombre)
            colorStandar(tarjetaFemina)
            botonesVoF()
        }

        // Pulsación en la tarjeta para mujer
        tarjetaFemina.setOnClickListener {
            cambioDeColor(tarjetaFemina)
            colorStandar(tarjetaHombre)
            botonesVoF()
        }

        // Cambio en la barra de medida de altura
        barraMedida.addOnChangeListener { _, value, _ ->
            alturaCM.text = value.toInt().toString()
        }

        // Pulsación en el botón de aumentar peso
        sumarPeso.setOnClickListener {
            var valorF = mostrarPeso.text.toString().toInt()
            valorF++
            mostrarPeso.text = valorF.toString()
        }

        // Pulsación en el botón de disminuir peso
        restarPeso.setOnClickListener {
            var valorF = mostrarPeso.text.toString().toInt()
            valorF--
            mostrarPeso.text = valorF.toString()
        }

        // Pulsación en el botón de aumentar edad
        sumarEdad.setOnClickListener {
            var valorF = mostrarEdad.text.toString().toInt()
            valorF++
            mostrarEdad.text = valorF.toString()
        }

        // Pulsación en el botón de disminuir edad
        restarEdad.setOnClickListener {
            var valorF = mostrarEdad.text.toString().toInt()
            valorF--
            mostrarEdad.text = valorF.toString()
        }

        //Pulsación en el botón de calculo de IMC para recibir el valor.
        btnCalculo.setOnClickListener {
            calculoIMC()
            val intent = Intent(this, activity_imc_resultado::class.java)
            startActivity(intent)
        }

        //Pulsación en el botón regresar para volver al menu principal.
        btnRegresar.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }
    }

    /**
     * Esta función alterna el estado de dos variables booleanas, `tarjIzq` y `tarjDer`,
     * utilizadas para realizar un seguimiento de la selección de tarjetas de género (hombre/mujer).
     * Cambia el estado de una tarjeta activa a la inactiva y viceversa.
     */
    private fun botonesVoF() {
        tarjIzq = !tarjIzq
        tarjDer = !tarjDer
    }

    /**
     * Esta función cambia el color de fondo de una tarjeta (CardView) a un color específico.
     *
     * @param tarjeta La tarjeta a la que se le cambiará el color de fondo.
     */
    private fun cambioDeColor(tarjeta: CardView) {
        val color = ContextCompat.getColor(this, R.color.gClaro)
        tarjeta.setCardBackgroundColor(color)
    }

    /**
     * Esta función restablece el color de fondo de una tarjeta (CardView) a su estado predeterminado.
     *
     * @param tarjeta La tarjeta a la que se le restablecerá el color de fondo.
     */
    private fun colorStandar(tarjeta: CardView) {
        val color = ContextCompat.getColor(this, R.color.gOscuro)
        tarjeta.setCardBackgroundColor(color)
    }

    /**
    * Calcula el Índice de Masa Corporal (IMC) utilizando los valores de altura y peso
    * proporcionados en la interfaz de usuario. Luego muestra el resultado del IMC en un mensaje
    * de Toast.
    */
    private fun calculoIMC() {
        // Obtén la cadena de altura
        val alturaStr = alturaCM.text.toString()

        // Elimina cualquier carácter no numérico (como "CM")
        val alturaLimpia = alturaStr.replace(Regex("[^0-9.]"), "")

        try {
            // Intenta convertir la cadena limpia a un valor numérico
            val altura = alturaLimpia.toDouble()

            // Calcula el IMC
            val IMC = mostrarPeso.text.toString().toInt() / ((altura / 100) * (altura / 100))

            // Redondea el IMC a dos decimales
            val redondeo = DecimalFormat("#.#")
            val resultado = redondeo.format(IMC)

            IMC_export = redondeo.format(IMC)

            // Muestra el resultado del IMC en un mensaje de tostada
            //Toast.makeText(this, "Su IMC es -> $resultado", Toast.LENGTH_LONG).show()


        } catch (e: NumberFormatException) {
            // Manejo de error: La cadena no se pudo convertir a un valor numérico
            Toast.makeText(this, "La altura no es un número válido", Toast.LENGTH_LONG).show()
        }
    }

}