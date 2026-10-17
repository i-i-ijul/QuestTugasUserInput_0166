package com.example.tugas5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp

@Composable
fun tugas(modifier: Modifier){
    var textNama by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var skill:List<String> = listOf("Android, UI/UX, Web")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            label = { Text(text = "Nama Depan") },
            onValueChange = {
                textNama = it
            }
        )
        Row{
            skill.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = {textJK = item}
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        })
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = textEmail,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = { Text("Email") },
            onValueChange = {
                textEmail = it
            }
        )
        HorizontalDivider(
            modifier = Modifier.padding(
                bottom =
                    dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(
                    R.dimen.padding_medium
                )
            ),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(1f),
            enabled = textEmail.isNotEmpty() && textNama.isNotEmpty() && textJK.isNotEmpty(),
            onClick = {
                nama = textNama
                skill = textJK
                email = textEmail
            }
        )
    }
}