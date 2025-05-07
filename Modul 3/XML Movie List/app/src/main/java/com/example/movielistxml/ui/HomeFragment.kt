package com.example.movielistxml.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielistxml.adapter.ListAdapter
import com.example.movielistxml.databinding.FragmentHomeBinding
import com.example.movielistxml.model.listItems
import androidx.navigation.fragment.findNavController
import com.example.movielistxml.R
import android.os.Bundle as AndroidBundle

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(
            listItems,
            onDetailClick = { selectedItem ->
                val bundle = Bundle().apply {
                    putInt("itemId", selectedItem.id)
                }
                findNavController().navigate(
                    R.id.action_homeFragment_to_detailFragment,
                    bundle
                )
            },
            onOpenLinkClick = { url ->
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}