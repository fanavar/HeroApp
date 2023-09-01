package cl.awakelab.heroapp.view

import android.content.Intent
import android.net.Uri
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
                if(!detailHero.translation){
                    binding.tvTraduccion.text = "sin traduccion"
                }else{
                    binding.tvTraduccion.text = "cuenta con traduccion al español"
                }
            }
        })
        binding.fab.setOnClickListener{
            val contact = "Comicconchile@hotmail.com"
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            val heroName = binding.tvName.text.toString()
            val heroId = id
            val subject = "Votación $heroName"
            val emailText = "Hola:\n Quiero que el siguiente super héroe $heroName aparezca en la nueva edición de biografías animadas.\n" +
                    "Número cotacto: +569________"
            val uriText = "mailto:$contact" +
                    "?subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(emailText)
            val uri = Uri.parse(uriText)
            emailIntent.data = uri

            startActivity(Intent.createChooser(emailIntent, "Votación..."))
        }



        return binding.root
    }






}