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
    }

    //Esta es la función para saltar entre pantallas
    //Tambien en Project -> Manifest -> AndroidManifest.xml se tiene que añadir una linea de codigo con los activitys de nuestro proyecto
    //<activity android:name=".MainActivityJuanJo"> </activity> ese es el mio por ejemplo.
    //El tuyo seria algo asi <activity android:name=".MainActivityDani"> </activity>
    //mira eso que te puede dar muchos dolors de cabeza, hace falta tener los 3 activitys ya metidos.
    //En mi calculadora he creado la funcion para volver al menu que es igual que esta y solo tienes que cambiar la R.id... y el Intent (this, Mainactivity), despues de mainActivity rellenas el
    //el nombre que quieras (ejemplo val intent = Intent(this, MainActivityDani::class.java)
    //https://www.youtube.com/watch?v=vJapzH_46a8&list=PL8ie04dqq7_OcBYDpvHrcSFVoggLi3cm_&ab_channel=Programaci%C3%B3nAndroidbyAristiDevs 4:10
    //de hay he sacado los datos.

    /**
     * Funcion creada para ir a una calculadora en específico.
     */

    //Dani copia y pega eso y lo modificas con las calculadoras de los demás, y intenta crear algun tipo de when cuando esten las 3 a ver si lo consigues.
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

}