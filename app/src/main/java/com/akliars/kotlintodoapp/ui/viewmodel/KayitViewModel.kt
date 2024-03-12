package com.akliars.kotlintodoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.akliars.kotlintodoapp.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var yrepo:YapilacaklarRepository): ViewModel() {
    // var krepo = KisilerRepository()

    fun kaydet(isin_adi:String,isin_detayi:String) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.kaydet(isin_adi,isin_detayi)
        }
    }
}