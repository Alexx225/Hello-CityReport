package com.example.cityreport
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityreport.databinding.ItemIncidenciaBinding
import com.example.cityreport.model.Incidencia

class IncidenciaAdapter(private val listaIncidencias: List<Incidencia>) :
    RecyclerView.Adapter<IncidenciaAdapter.IncidenciaViewHolder>() {

    class IncidenciaViewHolder(val binding: ItemIncidenciaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidenciaViewHolder {
        val binding = ItemIncidenciaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return IncidenciaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IncidenciaViewHolder, position: Int) {
        val incidencia = listaIncidencias[position]
        holder.binding.tvTitulo.text = incidencia.titulo
        holder.binding.tvUbicacion.text = "📍 ${incidencia.ubicacion}"
        holder.binding.tvEstado.text = "Estado: ${incidencia.estado}"
    }

    override fun getItemCount(): Int = listaIncidencias.size
}