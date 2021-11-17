package com.example.rickandmorty.ui.characterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.databinding.FragmentCharacterDetailsBinding
import org.koin.android.ext.android.inject

class CharacterDetailsFragment: Fragment() {
    private val viewModel: CharacterDetailsViewModel by inject()

    private lateinit var viewDataBinding: FragmentCharacterDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val args = arguments?.let { CharacterDetailsFragmentArgs.fromBundle(it) }
        args?.id?.let { viewModel.onSetupUi(it) }
        viewDataBinding = FragmentCharacterDetailsBinding.inflate(inflater, container, false).apply {
            vm = viewModel
            toolbar.title = args?.name ?: ""
        }
        viewDataBinding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
    }
}