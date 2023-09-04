package com.rns.jetm3.ui.data

import androidx.compose.ui.graphics.Color

data class Email(
    val sender: Sender,
    val subject: String,
    val body: String,
    val deliveryDate: String,
    val isUnread: Boolean,
    val isStarred: Boolean
)

data class Sender(val name: String, val color: Color)

