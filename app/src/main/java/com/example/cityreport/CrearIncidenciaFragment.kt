package com.example.cityreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.cityreport.databinding.FragmentCrearIncidenciaBinding
import com.example.cityreport.model.Incidencia
import com.example.cityreport.viewmodel.IncidenciaViewModel

class CrearIncidenciaFragment : Fragment() {

    private var _binding: FragmentCrearIncidenciaBinding? = null
    private val binding get() = _binding!!

    private val viewModel: IncidenciaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrearIncidenciaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGuardar.setOnClickListener {
            guardarIncidencia()
        }
    }

    private fun guardarIncidencia() {
        val titulo = binding.etTitulo.text.toString().trim()
        val ubicacion = binding.etUbicacion.text.toString().trim()
        val descripcion = binding.etDescripcion.text.toString().trim()

        // Validación de campos obligatorios
        if (titulo.isEmpty()) {
            binding.tilTitulo.error = "Ingresa un título"
            return
        } else {
            binding.tilTitulo.error = null
        }

        if (ubicacion.isEmpty()) {
            binding.tilUbicacion.error = "Ingresa una ubicación"
            return
        } else {
            binding.tilUbicacion.error = null
        }

        // Generar ID único incremental
        val totalActual = viewModel.incidencias.value?.size ?: 0
        val nuevoId = totalActual + 1

        val nuevaIncidencia = Incidencia(
            id = nuevoId,
            titulo = titulo,
            descripcion = if (descripcion.isEmpty()) "Sin descripción adicional" else descripcion,
            ubicacion = ubicacion,
            estado = "Pendiente"
        )

        // Guardar en el ViewModel
        viewModel.agregarIncidencia(nuevaIncidencia)

        Toast.makeText(requireContext(), "Reporte registrado con éxito", Toast.LENGTH_SHORT).show()

        // Regresar a la pantalla anterior
        findNavController().popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}