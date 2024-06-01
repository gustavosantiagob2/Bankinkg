package com.example.bankinkg.data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardTypes: String,
    val cardNumber: String,
    val cardName: String,
    val balance: Double,
    val color: Brush
)
