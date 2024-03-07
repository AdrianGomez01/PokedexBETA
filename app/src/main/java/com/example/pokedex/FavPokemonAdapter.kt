package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.FavPokemonItemBinding
import com.google.android.material.snackbar.Snackbar

class FavPokemonAdapter(
    private val favPokemonList: MutableList<Pokemon>,
    private val onClickDelete: (Int) -> Unit,
    private val onClickRoot: (Int) -> Unit,
) : RecyclerView.Adapter<FavPokemonAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = FavPokemonItemBinding.bind(view)
        fun bind(pokemon: Pokemon, onClickDelete: (Int) -> Unit, onClickRoot: (Int) -> Unit) {
            binding.tvName.text = pokemon.name
            binding.tvType1.text = pokemon.type1
            binding.tvType2.text = pokemon.type2
            val context = itemView.context
            binding.ivPhoto.setImageResource(
                context.resources.getIdentifier(
                    pokemon.photo,
                    PokeAdapter.PokemonViewHolder.DRAWABLE, context.packageName
                )
            )

            binding.root.setOnClickListener {
                onClickRoot(adapterPosition)
                Snackbar.make(it, "Has seleccionado a ${pokemon.name}.", Snackbar.LENGTH_SHORT)
                    .show()
            }

            binding.ivDelPoke.setOnClickListener {
                onClickDelete(adapterPosition)
                Snackbar.make(
                    it,
                    "Has eliminado a ${pokemon.name} de tus Pokemon favoritos.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.fav_pokemon_item, parent, false))
    }

    override fun getItemCount(): Int {
        return favPokemonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favPokemonList[position], onClickDelete, onClickRoot)
    }


}