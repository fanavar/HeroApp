package cl.awakelab.heroapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import cl.awakelab.heroapp.data.local.HeroDao
import cl.awakelab.heroapp.data.local.HeroEntity
import cl.awakelab.heroapp.data.remote.HeroApi

class Repository(private val heroApi: HeroApi, private val heroDao: HeroDao) {
    fun getHeroEntity(): LiveData<List<HeroEntity>> = heroDao.getHeroes()

    suspend fun getHeroes() {

        val response = heroApi.getData()
        if (response.isSuccessful) {

            val phones = response.body()
            if (phones != null) {
                //val heroEntities = phones.map { it.toHeroEntity() }
                //heroDao.insertHeroes(heroEntities)

            } else {
                Log.e("repository", response.errorBody().toString())
            }
        }

    }
}