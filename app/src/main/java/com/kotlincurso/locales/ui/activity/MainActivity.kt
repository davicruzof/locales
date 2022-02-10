package com.kotlincurso.locales.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlincurso.locales.databinding.ActivityMainBinding
import com.kotlincurso.locales.model.Card
import com.kotlincurso.locales.ui.recyclerview.adapter.ListaCardsAdapter
import com.kotlincurso.locales.ui.recyclerview.adapter.ListaCardsMinAdapter

class MainActivity : AppCompatActivity() {

    private val cards = listOf(
        Card(
            "Ana",
            "Description",
            "https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80",
            "3",
            "California",
            "1"
        ),
        Card(
            "Ana 2",
            "Description",
            "https://images.unsplash.com/photo-1568605114967-8130f3a36994?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8aG91c2V8ZW58MHx8MHx8&auto=format&fit=crop&w=600&q=60",
            "5",
            "California",
            "1"
        ),
        Card(
            "Ana 3",
            "Description",
            "https://images.unsplash.com/photo-1564013799919-ab600027ffc6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
            "13",
            "California",
            "4"
        ),
        Card(
            "Ana 4",
            "Description",
            "https://images.unsplash.com/photo-1600596542815-ffad4c1539a9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
            "3",
            "California",
            "3"
        ),
        Card(
            "Ana 5",
            "Description",
            "https://images.unsplash.com/photo-1600585154340-be6161a56a0c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTR8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
            "2",
            "California",
            "1"
        ),
        Card(
            "Ana 6",
            "Description",
            "https://images.unsplash.com/photo-1575517111478-7f6afd0973db?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
            "3",
            "California",
            "1"
        ),
        Card(
            "Ana 7",
            "Description",
            "https://images.unsplash.com/photo-1628744448840-55bdb2497bd4?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE1fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=600&q=60",
            "10",
            "California",
            "5"
        ),
        Card(
            "Ana 8",
            "Description",
            "https://images.unsplash.com/photo-1602343168117-bb8ffe3e2e9f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDR8fHxlbnwwfHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
            "1",
            "California",
            "1"
        ),
        Card(
            "Ana 9",
            "Description",
            "https://images.unsplash.com/photo-1582268611958-ebfd161ef9cf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjJ8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
            "3",
            "California",
            "2"
        ),
        Card(
            "Ana 10",
            "Description",
            "https://images.unsplash.com/photo-1513584684374-8bab748fbf90?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGhvdXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
            "5",
            "California",
            "3"
        )
    )

    private val adapter = ListaCardsAdapter(this, cards)
    private val adapter2 = ListaCardsMinAdapter(this, cards)

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerview.adapter = adapter
        binding.recyclerview2.adapter = adapter2

        adapter.quandoClicaNoItemListener = {
            val intent = Intent(
                this,
                DetailsActivity::class.java
            ).apply {
                putExtra(CARD_CHAVE, it)
            }
            startActivity(intent)
        }
    }
}