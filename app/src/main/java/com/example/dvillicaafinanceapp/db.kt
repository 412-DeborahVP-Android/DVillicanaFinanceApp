package com.example.dvillicaafinanceapp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class User(
    val name: String,
    val balance: Double
)

data class SummaryCard(
    val title: String,
    val amount: Double,
    val backgroundColor: Color
)

data class Transaction(
    val storeName: String,
    val category: String,
    val amount: Double,
    val time: String,
    val icon: ImageVector
)
