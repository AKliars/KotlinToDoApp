package com.akliars.kotlintodoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.akliars.kotlintodoapp.R
import com.akliars.kotlintodoapp.databinding.FragmentAnasayfaBinding
import com.akliars.kotlintodoapp.ui.adapter.YapilacaklarAdapter
import com.akliars.kotlintodoapp.ui.viewmodel.AnasayfaViewModel
import com.akliars.kotlintodoapp.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding : FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val yapilacaklarAdapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            binding.yapilacaklarRv.adapter = yapilacaklarAdapter
        }
        binding.yapilacaklarRv.layoutManager = LinearLayoutManager(requireContext())

        binding.ekleButon.setOnClickListener {
           // Navigation.findNavController(it).navigate(R.id.kayitGecis)
            Navigation.gecis(it,R.id.kayitGecis) // Navigation sınıfını kendi yazdığımız gecis fonksiyonu ile genişletmiş olduk. Yani özetler burada extension kullanmış olduk.

        }

        binding.searchView.setOnQueryTextListener( object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe çalışır
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Klavyedeki ara butonu ile çalışır
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }

}