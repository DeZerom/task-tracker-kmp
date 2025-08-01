package ru.dezerom.tasktracker.core.ui.kit.snackbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ru.dezerom.tasktracker.core.tools.stringContainer.StringContainer
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS
import ru.dezerom.tasktracker.core.ui.tools.getString

@Composable
fun BaseSnackbar(
    icon: ImageVector,
    messageContainer: StringContainer,
    bgColor: Color,
    testTag: String = "",
) {
    Card(
        colors = CardDefaults.cardColors().copy(containerColor = bgColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
            .padding(horizontal = 16.dp)
            .imePadding()
            .testTag(testTag)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Colors.white,
            )
            Text(
                text = messageContainer.getString(),
                style = TS.bodyMedium
            )
        }
    }
}

@Composable
fun SuccessSnackbar(
    messageContainer: StringContainer
) {
    BaseSnackbar(
        icon = Icons.Outlined.CheckCircle,
        messageContainer = messageContainer,
        bgColor = Colors.success,
    )
}

@Composable
fun ErrorSnackbar(
    messageContainer: StringContainer
) {
    BaseSnackbar(
        icon = Icons.Outlined.Close,
        messageContainer = messageContainer,
        bgColor = Colors.error,
    )
}