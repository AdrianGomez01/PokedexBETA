package com.example.pokedex

object Datasource {
    fun getPokemonList(): MutableList<Pokemon> {
        val pokemonList = mutableListOf<Pokemon>(
            Pokemon(
                "Absol",
                "Sinisestro",
                "---",
                "absol",
                "Corre por montañas y prados a la velocidad del viento. Su cuerno curvado tiene tal sensibilidad que puede predecir catástrofes naturales."
            ),
            Pokemon(
                "Pikachu",
                "Eléctrico",
                "---",
                "pikachu",
                "Cuando se enfada, este Pokémon descarga la energía que almacena en el interior de las bolsas de las mejillas."
            ),
            Pokemon(
                "Charizard",
                "Fuego",
                "Volador",
                "charizard",
                "Se dice que el fuego de Charizard arde con más fuerza cuantas más duras batallas haya vivido."
            ),
            Pokemon(
                "Venusaur",
                "Planta",
                "Veneno",
                "venusaur",
                "La planta florece cuando absorbe energía solar, lo cual le obliga a buscar siempre la luz del sol."
            ),
            Pokemon(
                "Alakazam",
                "Psíquico",
                "---",
                "alakazam",
                "Posee una capacidad intelectual fuera de lo común que le permite recordar todo lo sucedido desde el instante de su nacimiento"
            ),
            Pokemon(
                "Milotic",
                "Agua",
                "---",
                "milotic",
                "Se dice que es el Pokémon más bello. Ha sido la fuente de inspiración de un sinnúmero de artistas."
            )
        )
        //pokemonList.shuffle()
        return pokemonList
    }

    fun getFavPokemonList(): MutableList<Pokemon> {
        val pokemonList = mutableListOf<Pokemon>(

        )
        //pokemonList.shuffle()
        return pokemonList
    }
}