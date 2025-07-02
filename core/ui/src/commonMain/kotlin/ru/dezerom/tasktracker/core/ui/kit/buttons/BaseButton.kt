package ru.dezerom.tasktracker.core.ui.kit.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS

@Composable
fun BaseButton(
    onClick: () -> Unit,
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    textColor: Color = Colors.white,
    isLoading: Boolean = false,
    testTag: String = "",
) {
    Button(
        onClick = { if (!isLoading) onClick() },
        content = {
            if (isLoading) {
                CircularProgressIndicator(
                    color = Colors.darkSurface,
                    modifier = Modifier.size(36.dp)
                )
            } else {
                Text(
                    text = text,
                    style = TS.bodyLarge,
                    color = textColor,
                )
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(50.dp)
            .then(modifier)
            .testTag(testTag)
    )
}
