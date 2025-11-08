package ru.dezerom.tasktracker.taskList.ui.taskList.widgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material.icons.twotone.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.dezerom.tasktracker.core.resources.Res
import ru.dezerom.tasktracker.core.resources.task_card_collapse
import ru.dezerom.tasktracker.core.resources.task_card_completed_at
import ru.dezerom.tasktracker.core.resources.task_card_created_at
import ru.dezerom.tasktracker.core.resources.task_card_deadline_at
import ru.dezerom.tasktracker.core.resources.task_card_delete
import ru.dezerom.tasktracker.core.resources.task_card_edit
import ru.dezerom.tasktracker.core.resources.task_card_expand
import ru.dezerom.tasktracker.core.tools.extensions.toDayMonthYear
import ru.dezerom.tasktracker.core.ui.kit.Colors
import ru.dezerom.tasktracker.core.ui.kit.TS
import ru.dezerom.tasktracker.core.ui.kit.theme.TaskTrackerTheme
import ru.dezerom.tasktracker.core.ui.widgets.HSpacer
import ru.dezerom.tasktracker.core.ui.widgets.Loader
import ru.dezerom.tasktracker.core.ui.widgets.VSpacer
import ru.dezerom.tasktracker.taskList.domain.models.TaskModel

@Composable
internal fun TaskCard(
    task: TaskModel,
    isLoading: Boolean,
    onChangeCompleteStatus: (Boolean) -> Unit,
    onEditClicked: () -> Unit,
    onDeleteClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    var isLongName by remember { mutableStateOf(false) }
    var isLongDescription by remember { mutableStateOf(false) }
    val isLong = remember(isLongName, isLongDescription) {
        derivedStateOf { isLongName || isLongDescription }
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Colors.darkSurface),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Row {
                if (!isLoading) {
                    Checkbox(
                        checked = task.isCompleted,
                        onCheckedChange = onChangeCompleteStatus,
                        colors = CheckboxDefaults.colors(
                            checkedColor = Colors.accent,
                            uncheckedColor = Colors.accent,
                            checkmarkColor = Colors.white,
                        ),
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    Loader(
                        color =  Colors.accent,
                        size = 24.dp
                    )
                }
                HSpacer(8.dp)
                Text(
                    text = task.name,
                    style = TS.titleLarge,
                    maxLines = if (expanded) Int.MAX_VALUE else 2,
                    overflow = TextOverflow.Ellipsis,
                    onTextLayout = { isLongName = isLongName(it) },
                    modifier = Modifier.animateContentSize()
                )
            }
            if (task.description.isNotBlank()) {
                VSpacer(8.dp)
                Text(
                    text = task.description,
                    style = TS.bodyMedium.copy(color = Colors.secondaryText),
                    maxLines = if (expanded) Int.MAX_VALUE else 3,
                    overflow = TextOverflow.Ellipsis,
                    onTextLayout = { isLongDescription = isLongDescription(it) },
                    modifier = Modifier.animateContentSize()
                )
            }
            if (isLong.value) {
                VSpacer(8.dp)
                ExpandComponent(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            VSpacer(16.dp)
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = stringResource(Res.string.task_card_created_at, task.createdAt.toDayMonthYear()),
                        style = TS.bodyMedium,
                    )
                    VSpacer(4.dp)
                    if (task.deadline != null) {
                        Text(
                            text = stringResource(
                                Res.string.task_card_deadline_at, task.deadline!!.toDayMonthYear()
                            ),
                            style = TS.bodyMedium,
                        )
                        VSpacer(4.dp)
                    }
                    if (task.isCompleted && task.completedAt != null) {
                        Text(
                            text = stringResource(Res.string.task_card_completed_at, task.completedAt!!.toDayMonthYear()),
                            style = TS.bodyMedium.copy(color = Colors.secondaryText)
                        )
                    }
                }
                Row {
                    Icon(
                        imageVector = Icons.TwoTone.Delete,
                        tint = Colors.red,
                        contentDescription = stringResource(Res.string.task_card_delete),
                        modifier = Modifier.clickable { onDeleteClicked() }
                    )
                    HSpacer(8.dp)
                    Icon(
                        imageVector = Icons.TwoTone.Edit,
                        tint = Colors.white,
                        contentDescription = stringResource(Res.string.task_card_edit),
                        modifier = Modifier.clickable { onEditClicked() }
                    )
                }
            }
        }
    }
}

@Composable
private fun ExpandComponent(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier
) {
    val rotate by animateFloatAsState(targetValue = if (expanded) 180f else 0f)

    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Colors.background),
        onClick = onClick,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(4.dp)
                .padding(start = 4.dp)
        ) {
            Text(
                text = stringResource(
                    if (expanded) Res.string.task_card_collapse
                    else Res.string.task_card_expand
                ),
                style = TS.bodySmall.copy(color = Colors.white),
                modifier = Modifier.weight(1f),
            )
            HSpacer(8.dp)
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = stringResource(Res.string.task_card_expand),
                tint = Colors.white,
                modifier = Modifier.rotate(rotate)
            )
        }
    }
}

private fun isLongDescription(textResult: TextLayoutResult): Boolean {
    return textResult.lineCount > 3
            || textResult.isLineEllipsized(2.coerceAtMost(textResult.lineCount - 1))
}

private fun isLongName(textResult: TextLayoutResult): Boolean {
    return textResult.lineCount > 2
            || textResult.isLineEllipsized(1.coerceAtMost(textResult.lineCount - 1))
}

@Preview
@Composable
private fun TaskComponentPreview() {
    TaskTrackerTheme {
        TaskCard(
            task = TaskModel(
                id = "123",
                name = "Long long long long task name Long long long long task name Long long long long task name Long long long long task name Long long long long task name Long long long long task name Long long long long task name Long long long long task name",
                description = "aLong long long long task name Long long long long task name Long long long long task name Long long long long task namesd aLong long long long task name Long long long long task name Long long long long task name Long long long long task namesd aLong long long long task name Long long long long task name Long long long long task name Long long long long task namesd",
                createdAt = 1000,
                isCompleted = true,
                deadline = 1000000000000,
                completedAt = 100000000,
            ),
//            task = TaskModel(
//                id = "123",
//                name = "qwe",
//                description = "asd",
//                createdAt = 1000,
//                isCompleted = true,
//                deadline = 1000000000000,
//                completedAt = 100000000,
//            ),
            onChangeCompleteStatus = {},
            onDeleteClicked = {},
            onEditClicked = {},
            isLoading = true,
        )
    }
}