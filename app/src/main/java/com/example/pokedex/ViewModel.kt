package com.example.pokedex

import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var listaPokemon: MutableList<Pokemon> = mutableListOf()
    private var listaPokemonFavoritos: MutableList<Pokemon> = mutableListOf()
    private lateinit var descripcionPokemon: Pokemon
    private lateinit var userName: String

    fun addFavourite(nombre: String) {
        for (pokemon in listaPokemon) {
            if (pokemon.name.equals(nombre)) {
                if (!listaPokemonFavoritos.contains(pokemon))
                    listaPokemonFavoritos.add(pokemon)

            }
        }
    }

    fun delFavourite(nombre: String) {
        for (pokemon in listaPokemon) {
            if (pokemon.name.equals(nombre)) {
                if (listaPokemonFavoritos.contains(pokemon))
                    listaPokemonFavoritos.remove(pokemon)

            }
        }
    }

    fun getPokemon(): Pokemon {
        return descripcionPokemon
    }

    fun setPokemon(poke: Pokemon) {
        for (pokemon in listaPokemon) {
            if (pokemon.name.equals(poke.name)) {
                descripcionPokemon = poke
            }
        }
    }

    fun setUserName(name: String) {
        userName = name
    }

    fun getUserName(): String {
        return userName
    }

    fun getListaPokemonFavoritos(): MutableList<Pokemon> {
        return listaPokemonFavoritos
    }


    fun setListaPokemon(lista: MutableList<Pokemon>) {
        this.listaPokemon = lista
    }

}