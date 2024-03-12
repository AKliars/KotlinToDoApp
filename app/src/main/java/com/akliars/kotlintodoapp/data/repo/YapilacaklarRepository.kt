package com.akliars.kotlintodoapp.data.repo

import com.akliars.kotlintodoapp.data.datasource.YapilacaklarDataSource
import com.akliars.kotlintodoapp.data.entity.Yapilacaklar

class YapilacaklarRepository(var yds:YapilacaklarDataSource) {
//    var kds = KisilerDataSource()

    suspend fun kaydet(isin_adi:String,isin_detayi:String) = yds.kaydet(isin_adi,isin_detayi)

    suspend fun guncelle(id:Int,isin_adi:String,isin_detayi:String) = yds.guncelle(id, isin_adi, isin_detayi)

    suspend fun sil(id:Int) = yds.sil(id)

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> = yds.yapilacaklariYukle()

    suspend fun ara(aramaKelimesi : String) : List<Yapilacaklar> = yds.ara(aramaKelimesi)

}