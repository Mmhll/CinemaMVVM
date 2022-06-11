package com.mhl.cinemarate.ui.imdb

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mhl.cinemarate.R
import com.mhl.cinemarate.databinding.FragmentImdbBinding
import com.mhl.cinemarate.utils.MyItemClickListener
import com.mhl.cinemarate.utils.imdbrecycler.IMDBRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ImdbFragment : Fragment() {

    private var _binding: FragmentImdbBinding? = null
    private val binding get() = _binding!!

    private val viewModel : ImdbViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentImdbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.remoteData.observe(viewLifecycleOwner){
            Log.d("TAG", it.toString())
            var adapter = IMDBRecyclerAdapter(it, requireContext())
            adapter.setOnItemClickListener(object : MyItemClickListener{
                override fun onItemClick(position: Int) {
                    Toast.makeText(requireContext(), "KAVO", Toast.LENGTH_SHORT).show()
                }
            })
            binding.recyclerIMDB.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}