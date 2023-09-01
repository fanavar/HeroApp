package cl.awakelab.heroapp.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.awakelab.heroapp.data.Repository
import cl.awakelab.heroapp.data.local.HeroDatabase
import cl.awakelab.heroapp.data.remote.HeroRetrofit
import kotlinx.coroutines.launch

class HeroViewModel(application: Application): AndroidViewModel(application) {
    private val repository: Repository
    fun heroLiveData() = repository.getHeroEntity()
   // fun heroDetailLiveData() = repository.getHeroDetailEntity()

    init{
        val api = HeroRetrofit.getRetrofitHero()
        val heroDatabase = HeroDatabase.getDatabase(application).getHeroDao()
        repository = Repository(api, heroDatabase)
    }

    fun getHeroes() = viewModelScope.launch {
        repository.getHeroes()
    }
    fun getHeroDetail(id: Int) = viewModelScope.launch{
      //  repository.getHeroDetail(id)
    }



}