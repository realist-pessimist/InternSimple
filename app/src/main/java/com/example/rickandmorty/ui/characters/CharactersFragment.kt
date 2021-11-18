package com.example.rickandmorty.ui.characters

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.EventObserver
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentCharactersBinding
import com.example.rickandmorty.utils.extensions.onQueryTextChanged
import com.example.rickandmorty.utils.extensions.setupRefreshLayout
import org.koin.android.ext.android.inject

class CharactersFragment : Fragment() {
    private val viewModel: CharactersViewModel by inject()

    private lateinit var listAdapter: CharactersAdapter

    private lateinit var viewDataBinding: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FragmentCharactersBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        //TODO(Необходимо добавить SearchView с обращением ко ViewModel
        // для дальнейшей фильтрации персонажей)
        setupListAdapter()
        setupRefreshLayout(viewDataBinding.refreshLayout, viewDataBinding.rvCharacters)
        setupNavigation()
    }

    private fun setupListAdapter() {
        val viewModel = viewDataBinding.vm
        if (viewModel != null) {
            listAdapter = CharactersAdapter(viewModel)
            viewDataBinding.rvCharacters.adapter = listAdapter
        } else {
            Log.e(TAG, "ViewModel not initialized when attempting to set up adapter.")
        }
    }

    private fun setupNavigation() {
        viewModel.openCharacterEvent.observe(viewLifecycleOwner, EventObserver {
            openCharacterDetails(it.first, it.second)
        })
    }

    private fun openCharacterDetails(characterId: Int, characterName: String) {
        val action = CharactersFragmentDirections
            .actionCharactersToCharacterDetails(characterId, characterName)
        findNavController().navigate(action)
    }

    companion object {
        const val TAG = "CharactersViewModel"
    }
}