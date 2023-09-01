package cl.awakelab.heroapp.data.remote

import com.google.gson.annotations.SerializedName

data class Hero(
    val id: Int,
    @SerializedName("nombre") val name: String,
    @SerializedName("origen") val origin: String,
    @SerializedName("imagenLink") val imageLink: String,
    @SerializedName("poder") val power: String,
    @SerializedName("Año_creacion") val creationYear: Int
)