package com.denise.castro.todolist.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.denise.castro.todolist.R

@Composable
fun DialogDelete(
    onDismissRequest: () -> Unit = {},
    onConfirmClick: () -> Unit = {},
    painter: Painter,
    imageDescription: String
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(160.dp)
                )
                Text(
                    text = "ATENÇÃO!",
                    modifier = Modifier.padding(16.dp),
                    color = androidx.compose.ui.graphics.Color.Red,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                )
                Text(
                    text = "Ao excluir esta tarefa, ela será deletada permanentemente!",
                    modifier = Modifier.padding(16.dp),
                    color = androidx.compose.ui.graphics.Color.Black,
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = { onDismissRequest() },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(
                            "Cancelar",
                            color = androidx.compose.ui.graphics.Color.Black,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                        )
                    }
                    TextButton(
                        onClick = { onConfirmClick },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(
                            "Confirmar",
                            color = androidx.compose.ui.graphics.Color.Red,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun AlertDialogPreview() {
    DialogDelete(
        onDismissRequest = {},
        onConfirmClick = {},
        painter = painterResource(id = R.drawable.remove),
        imageDescription = "Ímagem de celular com uma lixeira grande na cor azul"
    )
}