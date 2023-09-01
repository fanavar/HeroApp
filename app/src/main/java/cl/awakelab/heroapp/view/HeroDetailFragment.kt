package cl.awakelab.heroapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.awakelab.heroapp.R
import cl.awakelab.heroapp.databinding.FragmentHeroDetailBinding
import coil.load

const val ARG_PARAM_ID = "heroId"

class HeroDetailFragment : Fragment() {
   lateinit var binding: FragmentHeroDetailBinding
   private val heroViewModel: HeroViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroDetailBinding.inflate(inflater, container, false)
        val heroId = arguments?.getInt("id")?: 0
        heroViewModel.getHeroDetail(heroId)
        heroViewModel.heroDetailLiveData(heroId).observe(viewLifecycleOwner, Observer { detailHero ->
            if(detailHero != null){
                binding.imageView4.load(detailHero.imageLink)
                binding.tvName.text = detailHero.name
                binding.tvOrigen.text = detailHero.origin
                binding.tvPoder.text = detailHero.power
                binding.tvCreacion.text = detailHero.creationYear.toString()
                binding.tvColor.text = detailHero.color
                binding.tvTraduccion.text = detailHero.traduccion

            }
        })




        return binding.root
    }






}