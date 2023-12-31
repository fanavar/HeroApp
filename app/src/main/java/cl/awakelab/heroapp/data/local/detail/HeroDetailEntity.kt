package cl.awakelab.heroapp.data.local.detail

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_detail_heroes")
data class HeroDetailEntity (
    @PrimaryKey val id: Int,
    @SerializedName("nombre") val name: String,
    @SerializedName("origen") val origin: String,
    @SerializedName("imagenLink") val imageLink: String,
    @SerializedName("poder") val power: String,
    @SerializedName("Año_creacion") val creationYear: Int,
    val color: String,
    @SerializedName("traduccion") val translation: Boolean
        )