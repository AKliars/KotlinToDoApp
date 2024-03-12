package com.akliars.kotlintodoapp.data.entity

import android.support.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacaklar")
data class Yapilacaklar(@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "id") @NotNull var id:Int,
                        @ColumnInfo(name = "isin_adi") @NotNull  var isin_adi:String,
                        @ColumnInfo(name = "isin_detayi") @NotNull var isin_detayi:String) : Serializable    {
}