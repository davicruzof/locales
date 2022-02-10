package com.kotlincurso.locales.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlincurso.locales.databinding.ActivityCardBinding
import com.kotlincurso.locales.model.Card
import com.kotlincurso.locals.extensions.tentaCarregarImagem

class ListaCardsAdapter(
    val context: Context,
    cards: List<Card>,
    var quandoClicaNoItemListener: (card: Card) -> Unit = {}
) : RecyclerView.Adapter<ListaCardsAdapter.ViewHolder>() {

    private val cards = cards.toMutableList()

    inner class ViewHolder(private val binding: ActivityCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var card: Card

        init {
            itemView.setOnClickListener {
                if (::card.isInitialized) {
                    quandoClicaNoItemListener(card)
                }
            }
        }

        fun vincula(card: Card) {
            this.card = card
            val title = binding.titleCard
            val subtitle = binding.subtitleCard
            val imagem = binding.imagemCard
            title.text = card.title
            subtitle.text = card.subtitle

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
        val view = ActivityCardBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = cards[position]
        holder.vincula(card)
    }

    override fun getItemCount(): Int = cards.size

}
