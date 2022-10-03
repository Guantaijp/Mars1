package com.example.mars1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mars1.databinding.FragmentOverviewBinding
import com.example.mars1.databinding.GridViewItemBinding

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        // val binding = GridViewItemBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter()
        return binding.root
    }
}