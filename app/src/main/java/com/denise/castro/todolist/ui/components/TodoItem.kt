package com.denise.castro.todolist.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.denise.castro.todolist.domain.Todo
import com.denise.castro.todolist.domain.todo1
import com.denise.castro.todolist.domain.todo2
import com.denise.castro.todolist.ui.theme.TodoListTheme

@Composable
fun TodoItem(
    todo: Todo,
    onCompletedChange: (Boolean) -> Unit,
    onItemClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        onClick = onItemClick,
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        color = if (todo.isCompleted) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.outline
        }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = todo.isCompleted,
                onCheckedChange = onCompletedChange,
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    uncheckedColor = MaterialTheme.colorScheme.onSurface
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = todo.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.LightGray
                )
                todo.description?.let {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = todo.description,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.LightGray
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                //onClick = onDeleteClick
                onClick = {
                    val showDialog = mutableStateOf(false)
                    showDialog.value = true
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Ícone de Lixeira",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoItemPreview() {
    TodoListTheme {
        TodoItem(
            todo = todo1,
            onCompletedChange = {},
            onItemClick = {},
            onDeleteClick = {}
        )
    }
}

@Preview
@Composable
private fun TodoItemCompletedPreview() {
    TodoListTheme {
        TodoItem(
            todo = todo2,
            onCompletedChange = {},
            onItemClick = {},
            onDeleteClick = {}
        )
    }
}