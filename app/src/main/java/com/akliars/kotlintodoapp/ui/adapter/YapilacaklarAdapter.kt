package com.akliars.kotlintodoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.akliars.kotlintodoapp.data.entity.Yapilacaklar
import com.akliars.kotlintodoapp.databinding.CardTasarimBinding
import com.akliars.kotlintodoapp.ui.fragment.AnasayfaFragmentDirections
import com.akliars.kotlintodoapp.ui.viewmodel.AnasayfaViewModel
import com.akliars.kotlintodoapp.utils.gecis
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(
    var mContext: Context,
    var yapilacaklarListesi:List<Yapilacaklar>,
    var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {//0,1,2
        val yapilacaklar = yapilacaklarListesi.get(position)
        val t = holder.tasarim

        t.textViewYapilacakIs.text = yapilacaklar.isin_adi
        t.textViewIsDetay.text = yapilacaklar.isin_detayi

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yapilacaklar=yapilacaklar)
            //  Navigation.findNavController(it).navigate(gecis)
            Navigation.gecis(it,gecis)
        }

        t.imageViewSilButon.setOnClickListener{
            Snackbar.make(it,"${yapilacaklar.isin_adi} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(yapilacaklar.id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }


}