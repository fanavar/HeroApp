package cl.awakelab.heroapp.data

import cl.awakelab.heroapp.data.local.HeroEntity
import cl.awakelab.heroapp.data.remote.Hero

fun Hero.toHeroEntity(): HeroEntity {
    return HeroEntity(
        id = this.id,
        name = this.name,
        origin = this.origin,
        imageLink = this.imageLink,
        power = this.power,
        creationYear = this.creationYear
    )
}