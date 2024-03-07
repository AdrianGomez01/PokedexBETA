package com.example.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.databinding.FragmentFavDetailsBinding

class DetailFavItemFragment : Fragment() {

    private var _binding: FragmentFavDetailsBinding? = null
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
        _binding = FragmentFavDetailsBinding.inflate(layoutInflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.fav_details)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        pokemon = sharedViewModel.getPokemon()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemon?.let {
            binding.ivFavPokeDetails.setImageResource(
                resources.getIdentifier(
                    it.photo,
                    "drawable",
                    requireContext().packageName
                )
            )
        }
        binding.tvFavPokeNameDetails.text = pokemon.name
        binding.tvFavTipo1Det.text = pokemon.type1
        binding.tvFavTipo2Det.text = pokemon.type2
        binding.tvFavDescsriptionDetails.text = pokemon.description
    }
}