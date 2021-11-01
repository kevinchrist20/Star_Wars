package com.kevinchrist.starwars

class StarWarsRepo {
    private val apiClient = StarWarsAPI()

    @Throws(Exception::class)
    suspend fun getPeoples() = apiClient.getPeoples()
}