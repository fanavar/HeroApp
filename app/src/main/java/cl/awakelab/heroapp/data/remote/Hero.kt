package cl.awakelab.heroapp.data.remote

data class Hero(
    val id: Int,
    val name: String,
    val origin: String,
    val imageLink: String,
    val power: String,
    val creationYear: Int
)