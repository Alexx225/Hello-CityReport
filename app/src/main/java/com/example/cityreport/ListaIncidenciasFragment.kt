package com.example.cityreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityreport.databinding.FragmentListaIncidenciasBinding
import com.example.cityreport.viewmodel.IncidenciaViewModel

class ListaIncidenciasFragment : Fragment() {

    private var _binding: FragmentListaIncidenciasBinding? = null
    private val binding get() = _binding!!

    private val viewModel: IncidenciaViewModel by activityViewModels()
    private lateinit var adapter: IncidenciaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaIncidenciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del Adapter con callback de navegación al detalle
        adapter = IncidenciaAdapter(emptyList()) { incidencia ->
            viewModel.incidenciaSeleccionada = incidencia
            findNavController().navigate(R.id.action_listaIncidenciasFragment_to_detalleIncidenciaFragment)
        }

        binding.rvIncidencias.layoutManager = LinearLayoutManager(requireContext())
        binding.rvIncidencias.adapter = adapter

        // Observar la lista del ViewModel en tiempo real
        viewModel.incidencias.observe(viewLifecycleOwner) { listaActualizada ->
            adapter.actualizarLista(listaActualizada)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}