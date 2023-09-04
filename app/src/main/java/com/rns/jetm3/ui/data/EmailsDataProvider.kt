package com.rns.jetm3.ui.data

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object EmailsDataProvider {
    private val sender = Sender(
        name = "Rasha Naser",
        color = Color(Random.nextLong(0xFFFFFFFF)).copy(alpha = .2f)
    )

    val EmailList = listOf(
        Email(
            sender = sender,
            subject = "Hello M3",
            body = "Jetpack Compose with Material 3",
            deliveryDate = "Sep 03",
            isUnread = false,
            isStarred = true
        ),
        Email(
            sender = sender,
            subject = "Hello M3",
            body = "Jetpack Compose with Material 3",
            deliveryDate = "Sep 03",
            isUnread = true,
            isStarred = false
        ),
        Email(
            sender = sender,
            subject = "Hello M3",
            body = "Jetpack Compose with Material 3",
            deliveryDate = "Sep 03",
            isUnread = true,
            isStarred = false
        ),
    )
}