package com.axel.ornelas.pruebabroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

class VerificarModoAvion(private val texto: TextView): BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val estaActivado = intent?.getBooleanExtra("state", false) ?: return
        val mensaje = if (estaActivado) "Modo avion activado" else "Modo avion desactivado"
        texto.text = mensaje
        Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
    }
}