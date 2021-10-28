package com.axel.ornelas.pruebabroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

class VerificarBateriaNormal(private val texto: TextView): BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val mensaje = "Gracias por no dejarme morir"
        texto.text = mensaje
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
    }
}