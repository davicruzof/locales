package com.kotlincurso.locales.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlincurso.locales.R
import com.kotlincurso.locales.databinding.ActivityDetailsBinding
import com.kotlincurso.locales.model.Card
import com.kotlincurso.locals.extensions.tentaCarregarImagem

class DetailsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tentaCarregarCard()
    }

    private fun tentaCarregarCard() {
        intent.getParcelableExtra<Card>(CARD_CHAVE)?.let { cardCarregado ->
            preencheCampos(cardCarregado)
        }?: finish()
    }

    private fun preencheCampos(cardCarregado: Card) {
        with(binding) {
            imagemDetails.tentaCarregarImagem(cardCarregado.imagem)
            titleDetails.text = cardCarregado.title
            subtitleDetails.text = cardCarregado.subtitle
            textoBathroom.text = cardCarregado.bathroom + " Banheiros"
            textoBedroom.text = cardCarregado.bedroom + " Quartos"
        }
    }
}