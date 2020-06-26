package com.example.sesion2gui

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*
import java.text.SimpleDateFormat
import java.util.*

class RegistroActivity : AppCompatActivity() {

    private lateinit var fecha: String
    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {    //Ciclo de vida
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        Log.d("OnCreate","ok")

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                if(year == cal.get(Calendar.YEAR)){
                    cal.set(Calendar.YEAR, 2000)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                }else{
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                }

                val format = "MM/dd/yyyy"
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)
                fecha = simpleDateFormat.format(cal.time)
                TV_fecha_nacimiento.text = fecha
            }

        }
        IB_calendario.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        BT_guardar.setOnClickListener {
            val nombre = ET_nombre.text.toString()
            val cedula = ET_cedula.text.toString()
            val correo = ET_correo.text.toString()
            val clave = ET_clave.text.toString()
            val rep_clave = ET_rep_clave.text.toString()
            val genero = if (RB_masculino.isChecked) "masculino" else "femenino"
            var pasatiempos = ""
            val ciudad_nacimiento = SP_cuidad_nacimiento.selectedItem.toString()

            if (CB_cine.isChecked) pasatiempos = "$pasatiempos cine"
            if (CB_ps4.isChecked) pasatiempos = "$pasatiempos ps4"
            if (CB_series.isChecked) pasatiempos = "$pasatiempos series"

            if (nombre.isEmpty() or cedula.isEmpty() or correo.isEmpty() or clave.isEmpty() or rep_clave.isEmpty()) {
                TV_imprimir.text = "Por favor, llene todos los espacios del formulario "
            } else if (clave == rep_clave) {
                TV_imprimir.text =
                    " Nombre: $nombre\n Cedula: $cedula\n Correo: $correo\n Fecha de nacimiento: $fecha\n Cuidad de nacimiento: $ciudad_nacimiento\n" +
                            " Genero: $genero\n" + " pasatiempos: $pasatiempos\n"
            } else {
                TV_imprimir.text = getString(R.string.error_claves)
            }
        }
    }
    //Crea el menu y se cargan las opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }
    //Se determina que item del menu se selecciona
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_actividad2){
            Log.d("Menu","Presionado el menu 1")
            val intent = Intent(this,LoginActivity::class.java)
            intent.putExtra("nombre",ET_nombre.text.toString())
            intent.putExtra("cedula", ET_cedula.text.toString().toLong())
            setResult(Activity.RESULT_OK,intent)
            finish()
            //startActivity(intent)
        }else{
            Log.d("Menu","Presionado el menu 2")
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnStart","ok")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResume","ok")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnPause","ok")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop","ok")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("OnRestart","ok")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy","ok")
    }
}