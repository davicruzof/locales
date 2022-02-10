package com.kotlincurso.locales.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlincurso.locales.databinding.ActivityCardMinBinding
import com.kotlincurso.locales.model.Card
import com.kotlincurso.locals.extensions.tentaCarregarImagem

class ListaCardsMinAdapter(
    val context: Context,
    private val cards: List<Card>
) : RecyclerView.Adapter<ListaCardsMinAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ActivityCardMinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(card: Card) {
            val title = binding.titleCardMin
            val locale = binding.localeCardMin
            val imagem = binding.imagemCardMin
            val bedroom = binding.textoBedroom
            val bathroom = binding.textoBathroom
            title.text = card.title
            locale.text = card.locale
            bedroom.text = card.bedroom + " Quartos"
            bathroom.text = card.bathroom + " Banheiros"

            val visibilidade = if (card.imagem != "") {
                View.VISIBLE
            } else {
                View.GONE
            }

            imagem.visibility = visibilidade

            imagem.tentaCarregarImagem(card.imagem)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = ActivityCardMinBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.vincula(card)
    }

    override fun getItemCount(): Int = cards.size

}
