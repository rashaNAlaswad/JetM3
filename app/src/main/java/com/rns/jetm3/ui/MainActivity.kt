package com.rns.jetm3.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rns.jetm3.AppPreviewsAnnotation
import com.rns.jetm3.ui.data.EmailsDataProvider.EmailList
import com.rns.jetm3.ui.components.GmailRowItem
import com.rns.jetm3.ui.components.SearchBar
import com.rns.jetm3.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
) {
    Surface(tonalElevation = 5.dp) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            LazyColumn(modifier = modifier) {
                item {
                    SearchBar(modifier = Modifier.fillMaxWidth())
                }
                items(EmailList) {
                    GmailRowItem(it)
                }
            }
        }
    }
}

@AppPreviewsAnnotation
@Composable
fun ReplyAppPreviewLight() {
    AppTheme {
        MyApp()
    }
}
