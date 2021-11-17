package com.example.rickandmorty.utils.binders

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.models.Character
import com.example.rickandmorty.ui.characters.CharactersAdapter

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Character>?) {
    items?.let {
        (listView.adapter as CharactersAdapter).submitList(items)
    }
}