package com.example.sesion2gui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var datosRecibidos = intent.extras
/*      var nombre = datosRecibidos?.getString("nombre")
        var cedula = datosRecibidos?.getLong("cedula")
        var telefono = datosRecibidos!!.getString("telefono")

        Toast.makeText(this,"Nombre:$nombre y cedula:$cedula y telefono:$telefono",Toast.LENGTH_LONG).show()*/

        button.setOnClickListener {
            //onBackPressed()
            val intent = Intent(this,RegistroActivity::class.java)
            startActivityForResult(intent,1234)
            //startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this,SplashActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1234 && resultCode == Activity.RESULT_OK){
            val nombre = data?.extras?.getString("nombre")
            val cedula = data?.extras?.getLong("cedula")
            Toast.makeText(this, "nombre:$nombre  y cedula:$cedula", Toast.LENGTH_LONG).show()
        }
    }

}