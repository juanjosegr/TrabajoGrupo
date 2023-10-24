package com.example.trabajogrupo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Dani estoy probando como es esto por si lo ves es la prueba para ver si funciona.
        val btnCalculadoraJuanjo = findViewById<Button>(R.id.calculadoraJuanjo)
        btnCalculadoraJuanjo.setOnClickListener{ navegarCalculadoraJuanjo() }

    }

    //Esta es la función para saltar entre pantallas
    //Tambien en Manifest, AndroidManifest.xml se tiene que añadir una linea de codigo con los activitys de nuestro proyecto
    //mira eso que te puede dar muchos dolors de cabeza, hace falta tener los 3 activitys ya metidos.
    //Supongo que con esta función creando un botón en tu calculdora y llamando a .activity_main podras volver atras.
    //https://www.youtube.com/watch?v=vJapzH_46a8&list=PL8ie04dqq7_OcBYDpvHrcSFVoggLi3cm_&ab_channel=Programaci%C3%B3nAndroidbyAristiDevs 4:10
    //de hay he sacado los datos.
    fun navegarCalculadoraJuanjo(){
        val intent = Intent(this, MainActivityJuanJo::class.java)
        startActivity(intent)
    }

}