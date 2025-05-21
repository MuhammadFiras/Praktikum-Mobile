package com.example.movielistxml.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movielistxml.databinding.FragmentDetailBinding
import androidx.lifecycle.ViewModelProvider
import com.example.movielistxml.ui.viewmodel.MovieViewModel
import com.example.movielistxml.ui.viewmodel.MovieViewModelFactory
import timber.log.Timber

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemId = arguments?.getInt("itemId") ?: return
        val factory = MovieViewModelFactory("From HomeFragment")
        val viewModel = ViewModelProvider(this, MovieViewModelFactory(factory.toString()))[MovieViewModel::class.java]
        val item = viewModel.getMovieById(itemId) ?: return

        // Set data ke UI
        binding.textViewTitle.text = item.name
        binding.textViewRating.text = "⭐ ${item.rating}"
        binding.textViewDescription.text = item.description

        Timber.i("Detail screen loaded with item: ID=${item.id}, Title='${item.name}', Rating=${item.rating}")

        val context = binding.root.context
        val imageResId = context.resources.getIdentifier(
            item.imageResName, "drawable", context.packageName
        )
        binding.imageView.setImageResource(imageResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}