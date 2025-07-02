package ru.dezerom.tasktracker.core.ui.kit.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS
import ru.dezerom.tasktracker.core.ui.widgets.HSpacer

@Composable
fun AccentExpandableFAB(
    onClick: () -> Unit,
    icon: ImageVector,
    expandedText: String,
    isExpanded: Boolean = false
) {
    FloatingActionButton(
        containerColor = Colors.accent,
        onClick = onClick
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (isExpanded) {
                HSpacer(16.dp)
            }
            Icon(
                icon,
                contentDescription = null,
            )
            AnimatedVisibility(isExpanded) {
                Row {
                    HSpacer(4.dp)
                    Text(
                        text = expandedText,
                        style = TS.bodyMedium
                    )
                    HSpacer(16.dp)
                }

            }
        }
    }
}
