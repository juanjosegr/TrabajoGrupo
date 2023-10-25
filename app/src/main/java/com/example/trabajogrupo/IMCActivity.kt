package com.example.trabajogrupo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class IMCActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        btnRegresarMenu()





    }






    private fun btnRegresarMenu(){
        val btnRegresar = findViewById<Button>(R.id.btnRegresarIMC)
        btnRegresar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }
    }
}