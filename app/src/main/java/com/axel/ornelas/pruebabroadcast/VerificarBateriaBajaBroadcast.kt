package com.axel.ornelas.pruebabroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

class VerificarBateriaBajaBroadcast(private val texto: TextView) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val mensaje = "Me estoy muriendo :("
        texto.text = mensaje
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
    }
}