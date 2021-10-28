package com.axel.ornelas.pruebabroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.TextView

//https://developer.android.com/training/monitoring-device-state/battery-monitoring?hl=es-419#kotlin

class CambioBateria(private val texto: TextView) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val nivelBateria = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: return
        val escala = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val bateria = (nivelBateria * 100 / escala.toFloat())
        texto.text = "Nivel de Bateria: $bateria"
    }

}