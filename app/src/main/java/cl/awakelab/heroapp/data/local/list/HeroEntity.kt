package cl.awakelab.heroapp.data.local.list

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_heroes")
data class HeroEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val origin: String,
     val imageLink: String,
     val power: String,
     val creationYear: Int
)