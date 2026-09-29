package com.example.cityreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cityreport.databinding.FragmentDetalleIncidenciaBinding
import com.example.cityreport.viewmodel.IncidenciaViewModel

class DetalleIncidenciaFragment : Fragment() {

    private var _binding: FragmentDetalleIncidenciaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: IncidenciaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalleIncidenciaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Cargar datos de la incidencia seleccionada
        val incidencia = viewModel.incidenciaSeleccionada

        if (incidencia != null) {
            binding.tvTituloDetalle.text = incidencia.titulo
            binding.tvEstadoDetalle.text = "Estado: ${incidencia.estado}"
            binding.tvUbicacionDetalle.text = "📍 ${incidencia.ubicacion}"
            binding.tvDescripcionDetalle.text = incidencia.descripcion
        }

        // Regresar a la pantalla anterior
        binding.btnRegresar.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}