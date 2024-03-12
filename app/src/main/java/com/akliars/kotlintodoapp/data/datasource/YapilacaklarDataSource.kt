package com.akliars.kotlintodoapp.data.datasource

import com.akliars.kotlintodoapp.data.entity.Yapilacaklar
import com.akliars.kotlintodoapp.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource (var ydao:YapilacaklarDao){
    suspend fun kaydet(isin_adi:String,isin_detayi:String){
        val yeniIs = Yapilacaklar(0,isin_adi,isin_detayi)
        ydao.kaydet(yeniIs)
    }

    suspend fun guncelle(id:Int,isin_adi: String,isin_detayi:String){
        val guncellenenIs = Yapilacaklar(id,isin_adi,isin_detayi)
        ydao.guncelle(guncellenenIs)
    }

    suspend fun sil(id:Int){
        val silinenIs = Yapilacaklar(id ,"","")
        ydao.sil(silinenIs)
    }

    suspend fun yapilacaklariYukle() : List<Yapilacaklar> =
        withContext(Dispatchers.IO){
            return@withContext ydao.yapilacaklariYukle()
        }

    suspend fun ara(aramaKelimesi : String) : List<Yapilacaklar> = withContext(Dispatchers.IO) {
        withContext(Dispatchers.IO){
            return@withContext ydao.ara(aramaKelimesi)
        }
    }
}