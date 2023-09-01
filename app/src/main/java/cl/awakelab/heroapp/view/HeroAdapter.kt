package cl.awakelab.heroapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.awakelab.heroapp.data.local.HeroEntity
import cl.awakelab.heroapp.databinding.FragmentHeroListBinding
import cl.awakelab.heroapp.databinding.ItemHeroBinding
import coil.load


class HeroAdapter: RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {


    lateinit var binding: ItemHeroBinding
    private var heroesList = mutableListOf<HeroEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.HeroViewHolder {
        binding = ItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HeroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroAdapter.HeroViewHolder, position: Int) {
        val hero = heroesList[position]
        holder.bind(hero)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }
    fun setData(phone: List<HeroEntity>){
        this.heroesList.clear()
        this.heroesList.addAll(phone)
        notifyDataSetChanged()
    }


    inner class HeroViewHolder(val heroesViews: ItemHeroBinding ): RecyclerView.ViewHolder(heroesViews.root) {
        fun bind(hero: HeroEntity){
            //vista del item hero layout
            heroesViews.tvNameItem.text = hero.name
            heroesViews.tvPowerItem.text = hero.power
            heroesViews.imageItem.load(hero.imageLink)
        }
    }

}