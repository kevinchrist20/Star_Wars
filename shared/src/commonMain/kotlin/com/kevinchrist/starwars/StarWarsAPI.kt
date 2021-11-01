package com.kevinchrist.starwars

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*

class StarWarsAPI {
    companion object {
        private const val BASE_URL = "https://swapi.dev/api/"
        private const val PEOPLES_URL = "$BASE_URL/people"
    }

    private val httpClient = HttpClient() {
        install(JsonFeature) {
            serializer =
                KotlinxSerializer(kotlinx.serialization.json.Json { ignoreUnknownKeys = true })
        }
    }

    suspend fun getPeoples() = httpClient.get<PeopleResponse>(PEOPLES_URL)
}