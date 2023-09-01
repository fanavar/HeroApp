package cl.awakelab.heroapp.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface HeroApi {
    @GET("superheroes/")
    suspend fun getData(): Response<List<Hero>>
}