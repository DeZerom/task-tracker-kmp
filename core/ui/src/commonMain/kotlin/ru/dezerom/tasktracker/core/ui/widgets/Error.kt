package ru.dezerom.tasktracker.core.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.kit_err_while_loading
import ru.dezerom.tasktracker.core.resources.kit_try_again
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS
import ru.dezerom.tasktracker.core.ui.kit.buttons.WhiteButton
import ru.dezerom.tasktracker.core.ui.tools.getString

@Composable
fun DefaultErrorComponent(onTryAgain: () -> Unit, err: StringContainer) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Warning,
            contentDescription = null,
            tint = Colors.darkSurface,
            modifier = Modifier.size(192.dp)
        )
        VSpacer(16.dp)
        Text(
            text = stringResource(Res.string.kit_err_while_loading),
            style = TS.titleLarge
        )
        VSpacer(8.dp)
        Text(
            text = err.getString(),
            style = TS.bodySmall.copy(textAlign = TextAlign.Center)
        )
        VSpacer(24.dp)
        WhiteButton(
            text = stringResource(Res.string.kit_try_again),
            onClick = onTryAgain,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}