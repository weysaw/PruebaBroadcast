package com.axel.ornelas.pruebabroadcast


import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var bateriaBaja: VerificarBateriaBajaBroadcast
    private lateinit var bateriaNormal: VerificarBateriaNormal
    private lateinit var bateriaCambia: CambioBateria
    private lateinit var modoAvion: VerificarModoAvion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val texto = findViewById<TextView>(R.id.texto)
        //Inicializa los receiver
        bateriaBaja = VerificarBateriaBajaBroadcast(texto)
        modoAvion = VerificarModoAvion(texto)
        bateriaNormal = VerificarBateriaNormal(texto)
        bateriaCambia = CambioBateria(findViewById(R.id.bateria))

        //Se registran los receivers
        IntentFilter(Intent.ACTION_BATTERY_LOW).also {
            registerReceiver(bateriaBaja, it)
        }
        IntentFilter(Intent.ACTION_BATTERY_OKAY).also {
            registerReceiver(bateriaNormal, it)
        }
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(modoAvion, it)
        }
        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
            registerReceiver(bateriaCambia, it)
        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(bateriaBaja)
        unregisterReceiver(bateriaNormal)
        unregisterReceiver(modoAvion)
        unregisterReceiver(bateriaCambia)
    }
}