package com.denise.castro.todolist.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.denise.castro.todolist.ui.theme.TodoListTheme

@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: String = "",
    leadingIconImageVector: ImageVector,
    leadingIconDescription: String,
    showError: Boolean = false,
    errorMessage: String? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            label = { Text(label) },
            shape = RoundedCornerShape(12.dp),
            leadingIcon = {
                Icon(
                    imageVector = leadingIconImageVector,
                    contentDescription = leadingIconDescription,
                    tint =
                    if (showError) MaterialTheme.colorScheme.error
                    else MaterialTheme.colorScheme.onSurface
                )
            },
            isError = showError
        )
        if (showError) {
            Text(
                text = errorMessage ?: "",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .fillMaxWidth(),
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CustomOutlinedTextFieldPreview() {
    TodoListTheme {
        CustomOutlinedTextField(
            value = "",
            onValueChange = {},
            label = "Título",
            placeholder = "Digite um título para a sua tarefa",
            leadingIconImageVector = Icons.Default.Warning,
            leadingIconDescription = "Warning",
        )
    }
}