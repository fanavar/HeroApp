package cl.awakelab.heroapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {
    @GET("superheroes/")
    suspend fun getData(): Response<List<Hero>>

    @GET("superheroes/{id}")
    suspend fun  getHeroDetail(@Path("id") id: Int): Response<HeroDetail>
}