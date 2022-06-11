package com.mhl.cinemarate.ui.kinopoisk

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.mhl.cinemarate.databinding.FragmentKinopoiskBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KinopoiskFragment : Fragment() {

    private var _binding: FragmentKinopoiskBinding? = null
    private val binding get() = _binding!!

    private val viewModel : KinopoiskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKinopoiskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner){
            Log.d("KINOPOISK_TAG", it.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}