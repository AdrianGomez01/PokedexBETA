package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.PokemonItemBinding
import com.google.android.material.snackbar.Snackbar

class PokeAdapter(
    private val pokemonList: MutableList<Pokemon>,
    private val onClickAdd: (Int) -> Unit,
    private val onClickRoot: (Int) -> Unit,
) : RecyclerView.Adapter<PokeAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        companion object {
            const val DRAWABLE = "drawable"
        }

        private val binding = PokemonItemBinding.bind(view)

        fun bind(pokemon: Pokemon, onClickAdd: (Int) -> Unit, onClickRoot: (Int) -> Unit) {
            binding.tvName.text = pokemon.name
            binding.tvType1.text = pokemon.type1
            binding.tvType2.text = pokemon.type2
            val context = itemView.context
            binding.ivPhoto.setImageResource(
                context.resources.getIdentifier(
                    pokemon.photo,
                    DRAWABLE,
                    context.packageName
                )
            )

            binding.root.setOnClickListener {
                onClickRoot(adapterPosition)
                Snackbar.make(it, "Has seleccionado a ${pokemon.name}.", Snackbar.LENGTH_SHORT)
                    .show()
            }

            binding.ivFavPoke.setOnClickListener {
                onClickAdd(adapterPosition)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(layoutInflater.inflate(R.layout.pokemon_item, parent, false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemonList[position], onClickAdd, onClickRoot)
    }

}