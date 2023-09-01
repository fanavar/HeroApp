package cl.awakelab.heroapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroEntity: List<HeroEntity>)

    @Query("Select * from table_heroes order by id asc")
    fun getHeroes(): LiveData<List<HeroEntity>>

}