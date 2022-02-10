package com.kotlincurso.locals.extensions

import android.widget.ImageView
import coil.load
import com.kotlincurso.locales.R

fun ImageView.tentaCarregarImagem(url: String? = null){
    load(url) {
        // caso a imagem não carregue
        fallback(R.drawable.placeholder)
        // caso a imagem ocorra um erro no carregamento
        error(R.drawable.placeholder)
        placeholder(R.drawable.placeholder)
    }
}
