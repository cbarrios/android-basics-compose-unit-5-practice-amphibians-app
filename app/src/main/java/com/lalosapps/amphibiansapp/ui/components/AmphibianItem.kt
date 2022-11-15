package com.lalosapps.amphibiansapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.lalosapps.amphibiansapp.data.network.dto.Amphibian

@Composable
fun AmphibianItem(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "${amphibian.name} (${amphibian.type})",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = amphibian.description,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.height(8.dp))

            Box {
                var showProgress by rememberSaveable { mutableStateOf(false) }
                var showError by rememberSaveable { mutableStateOf(false) }
                if (showProgress) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(250.dp), contentAlignment = Alignment.Center
                    ) {
                        if (showError) {
                            Image(
                                modifier = Modifier.size(50.dp),
                                imageVector = Icons.Default.Warning,
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(Color.Red)
                            )
                        } else {
                            CircularProgressIndicator()
                        }
                    }
                }
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(250.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(amphibian.image)
                        .crossfade(1000)
                        .build(),
                    onLoading = {
                        showProgress = true
                        showError = false
                    },
                    onError = { showError = true },
                    onSuccess = {
                        showProgress = false
                        showError = false
                    },
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}