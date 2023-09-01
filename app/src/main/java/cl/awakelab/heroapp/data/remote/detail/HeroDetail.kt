package cl.awakelab.heroapp.data.remote.detail

import com.google.gson.annotations.SerializedName

class HeroDetail (
    val id: Int,
    @SerializedName("nombre") val name: String,
    @SerializedName("origen") val origin: String,
    @SerializedName("imagenLink") val imageLink: String,
    @SerializedName("poder") val power: String,
    @SerializedName("Año_creacion") val creationYear: Int,
    val color: String,
    @SerializedName("traduccion") val translation: Boolean

    )