package ru.dezerom.tasktracker.core.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.kit_loading
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS

@Composable
fun DefaultLoaderComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Loader()
        VSpacer(8.dp)
        Text(
            text = stringResource(Res.string.kit_loading),
            style = TS.bodyLarge
        )
    }
}

@Composable
fun Loader(
    size: Dp = 48.dp,
    color: Color = Colors.white,
) {
    CircularProgressIndicator(
        color = color,
        modifier = Modifier.size(size)
    )
}