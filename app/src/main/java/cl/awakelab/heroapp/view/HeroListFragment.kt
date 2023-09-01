package cl.awakelab.heroapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

import cl.awakelab.heroapp.databinding.FragmentHeroListBinding

class HeroListFragment : Fragment() {
    lateinit var binding: FragmentHeroListBinding
    private val phoneViewModel: HeroViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHeroListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        phoneViewModel.getHeroes()
        return binding.root
    }
    private fun initAdapter() {
        val adapter = HeroAdapter()

        binding.rvHeroList.adapter = adapter
        phoneViewModel.heroLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}