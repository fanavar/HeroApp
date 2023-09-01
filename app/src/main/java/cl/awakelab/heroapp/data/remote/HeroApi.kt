package cl.awakelab.heroapp.data.remote

import cl.awakelab.heroapp.data.remote.detail.HeroDetail
import cl.awakelab.heroapp.data.remote.list.Hero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApi {
    @GET("superheroes/")
    suspend fun getData(): Response<List<Hero>>

    @GET("superheroes/{id}")
    suspend fun  getHeroDetail(@Path("id") id: Int): Response<HeroDetail>
}