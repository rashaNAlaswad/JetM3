package com.rns.jetm3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.rns.jetm3.AppPreviewsAnnotation
import com.rns.jetm3.ui.data.Email
import com.rns.jetm3.ui.data.EmailsDataProvider
import com.rns.jetm3.ui.theme.AppTheme

@Composable
fun GmailRowItem(email: Email, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .background(
                MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(
            containerColor = if (email.isStarred)
                MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column {
                Surface(
                    shape = CircleShape,
                    modifier = Modifier.size(30.dp),
                    color = email.sender.color
                ) {
                    Text(
                        text = email.sender.name.first().toString(),
                        modifier = Modifier.wrapContentSize(),
                        color = MaterialTheme.colorScheme.inverseSurface
                    )
                }
            }

            val weight = if (email.isUnread) FontWeight.Bold else FontWeight.Light
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = email.sender.name, fontWeight = weight,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = email.subject,
                    fontWeight = weight,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                )
                Text(
                    text = email.body,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            val icon = if (email.isStarred) Icons.Filled.Star else Icons.Filled.StarBorder
            Column(horizontalAlignment = Alignment.End) {
                Text(text = email.deliveryDate)
                Spacer(modifier = Modifier.height(8.dp))
                Image(imageVector = icon, contentDescription = "Starred")
            }
        }
    }
}

@AppPreviewsAnnotation
@Composable
fun GmailRowItemPreview() {
    AppTheme {
        GmailRowItem(EmailsDataProvider.EmailList.first())
    }
}
