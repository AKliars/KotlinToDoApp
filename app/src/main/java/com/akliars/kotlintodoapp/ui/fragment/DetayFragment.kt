package com.akliars.kotlintodoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.akliars.kotlintodoapp.databinding.FragmentDetayBinding
import com.akliars.kotlintodoapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint
import hilt_aggregated_deps._com_akliars_kotlintodoapp_ui_fragment_DetayFragment_GeneratedInjector
import javax.inject.Inject

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding : FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        val bundle:DetayFragmentArgs by navArgs()
        val gelenYapilacaklar = bundle.yapilacaklar

        binding.editTextIsAd.setText(gelenYapilacaklar.isin_adi)
        binding.editTextIsDetay.setText(gelenYapilacaklar.isin_detayi)
        binding.buttonGuncelle.setOnClickListener {
            val isin_adi = binding.editTextIsAd.text.toString()
            val isin_detayi = binding.editTextIsDetay.text.toString()
            viewModel.guncelle(gelenYapilacaklar.id, isin_adi, isin_detayi)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}







