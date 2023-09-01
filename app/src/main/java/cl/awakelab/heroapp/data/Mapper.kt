package cl.awakelab.heroapp.data

import cl.awakelab.heroapp.data.local.detail.HeroDetailEntity
import cl.awakelab.heroapp.data.local.list.HeroEntity
import cl.awakelab.heroapp.data.remote.list.Hero
import cl.awakelab.heroapp.data.remote.detail.HeroDetail

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

fun HeroDetail.toHeroDetailEntity(): HeroDetailEntity {
    return HeroDetailEntity(
        id = this.id,
        name = this.name,
        origin = this.origin,
        imageLink = this.imageLink,
        power = this.power,
        creationYear = this.creationYear,
        color = this.color,
        translation = this.translation
    )
}