package com.akliars.kotlintodoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.akliars.kotlintodoapp.R
import com.akliars.kotlintodoapp.databinding.FragmentKayitBinding
import com.akliars.kotlintodoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {

    private lateinit var binding : FragmentKayitBinding
    private lateinit var viewModel : KayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKayitBinding.inflate(inflater,container,false)

        binding.buttonKaydet.setOnClickListener {
            val isin_adi = binding.editTextKayitIsAd.text.toString()
            val isin_detayi = binding.editTextKayitIsDetay.text.toString()
            viewModel.kaydet(isin_adi,isin_detayi)
        }






        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}