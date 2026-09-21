package com.example.cityreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cityreport.databinding.FragmentListaIncidenciasBinding

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
}