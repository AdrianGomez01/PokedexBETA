package com.example.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.databinding.FragmentDetailsBinding

//DONE
class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var pokemon: Pokemon


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.details)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        pokemon = sharedViewModel.getPokemon()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemon?.let {
            binding.ivPokeDetails.setImageResource(
                resources.getIdentifier(
                    it.photo,
                    "drawable",
                    requireContext().packageName
                )
            )
        }
        binding.tvPokeNameDetails.text = pokemon.name
        binding.tvTipo1Det.text = pokemon.type1
        binding.tvTipo2Det.text = pokemon.type2
        binding.tvDescriptionDetails.text = pokemon.description
    }
}