package com.example.cityreport.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityreport.model.Incidencia

class IncidenciaViewModel : ViewModel() {

    // Estado global en memoria para las incidencias
    private val _incidencias = MutableLiveData<MutableList<Incidencia>>(
        mutableListOf(
            Incidencia(1, "Bache en Av. Principal", "Bache profundo causa tráfico constante.", "Av. Central #102", "Pendiente"),
            Incidencia(2, "Fuga de Agua", "Tubería rota en banqueta.", "Calle Hidalgo #45", "En proceso"),
            Incidencia(3, "Luminaria Fundida", "Falta de alumbrado público.", "Parque Lineal", "Resuelto")
        )
    )
    val incidencias: LiveData<MutableList<Incidencia>> get() = _incidencias

    // Método para agregar una nueva incidencia desde el formulario
    fun agregarIncidencia(incidencia: Incidencia) {
        val listaActual = _incidencias.value ?: mutableListOf()
        listaActual.add(incidencia)
        _incidencias.value = listaActual
    }
}