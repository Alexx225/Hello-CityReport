package com.example.cityreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cityreport.databinding.FragmentListaIncidenciasBinding
import com.example.cityreport.model.Incidencia

class ListaIncidenciasFragment : Fragment() {

    // Manejo seguro del View Binding dentro del ciclo de vida del Fragment
    private var _binding: FragmentListaIncidenciasBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaIncidenciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Previene fugas de memoria (memory leaks)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Crear datos de prueba usando el modelo Incidencia (Persona A)
        val listaMock = listOf(
            Incidencia(1, "Bache en Av. Principal", "Bache profundo causa tráfico.", "Av. Central #102", "Pendiente"),
            Incidencia(2, "Fuga de Agua", "Tubería rota en banqueta.", "Calle Hidalgo #45", "En proceso"),
            Incidencia(3, "Luminaria Fundida", "Falta de alumbrado público.", "Parque Lineal", "Resuelto")
        )

        // 2. Conectar el RecyclerView con el Adapter (Persona A + Persona B)
        binding.rvIncidencias.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
        binding.rvIncidencias.adapter = IncidenciaAdapter(listaMock)
    }
}