package com.kotlincurso.locales.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Card(
    val title: String,
    val subtitle: String,
    val imagem: String,
    val bedroom: String,
    val locale: String,
    val bathroom: String,
): Parcelable