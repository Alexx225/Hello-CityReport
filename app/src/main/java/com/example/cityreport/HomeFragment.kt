package com.example.cityreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cityreport.databinding.FragmentHomeBinding
import com.example.cityreport.viewmodel.IncidenciaViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    // ViewModel compartido con la Activity
    private val viewModel: IncidenciaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observa la lista para actualizar el contador en tiempo real
        viewModel.incidencias.observe(viewLifecycleOwner) { lista ->
            binding.tvTotalIncidencias.text = "Reportes registrados: ${lista.size}"
        }

        // Navegación hacia la Lista de Incidencias
        binding.btnVerReportes.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_listaIncidenciasFragment)
        }

        // Navegación hacia el Formulario de Creación
        binding.btnCrearReporte.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_crearIncidenciaFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}