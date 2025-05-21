package com.example.movielistxml.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistxml.databinding.ItemRowBinding
import com.example.movielistxml.model.ListItem

class ListAdapter(
    private val list: List<ListItem>,
    private val onDetailClick: (ListItem) -> Unit,
    private val onOpenLinkClick: (String) -> Unit
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListItem) {
            binding.textViewName.text = item.name
            binding.textViewRating.text = "⭐ ${item.rating}"
            binding.textViewDescription.text = item.description

            val context = binding.root.context
            val imageResId = context.resources.getIdentifier(
                item.imageResName, "drawable", context.packageName
            )
            binding.imageView.setImageResource(imageResId)

            binding.buttonDetail.setOnClickListener {
                onDetailClick(item)
            }

            binding.buttonIMDb.setOnClickListener {
                onOpenLinkClick(item.link)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}