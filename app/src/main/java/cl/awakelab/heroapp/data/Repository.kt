package cl.awakelab.heroapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelab.heroapp.data.local.HeroDao
import cl.awakelab.heroapp.data.local.HeroDetailEntity
import cl.awakelab.heroapp.data.local.HeroEntity
import cl.awakelab.heroapp.data.remote.HeroApi

class Repository(private val heroApi: HeroApi, private val heroDao: HeroDao) {
    fun getHeroEntity(): LiveData<List<HeroEntity>> = heroDao.getHeroes()

    fun getHeroDetailEntity(id: Int): LiveData<HeroDetailEntity> =
        heroDao.getHeroDetail(id)


    suspend fun getHeroes() {

        val response = heroApi.getData()
        if (response.isSuccessful) {

            val phones = response.body()
            if (phones != null) {
                val heroEntities = phones.map { it.toHeroEntity() }
                heroDao.insertHeroes(heroEntities)

            } else {
                Log.e("repository", response.errorBody().toString())
            }
        }

    }

    suspend fun getHeroDetail(id: Int)  {
        try {
            val response = heroApi.getHeroDetail(id)
            Log.e("repository", "response")
            if (response.isSuccessful) {
                val heroDetail = response.body()
                if (heroDetail != null) {
                    Log.e("repository", "$heroDetail")
                    val heroEntity = heroDetail.toHeroDetailEntity()
                    heroDao.insertHeroDetail(heroEntity)
                } else {
                    Log.e("repository", "Error getting phone detail: Response body is null")
                }
            } else {
                Log.e("repository", "Error getting phone detail: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            Log.e("repository", "Exception while getting phone detail: ${e.message}")
        }

    }
}