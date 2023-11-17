package com.example.ucp2_pam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucp2_pam.ui.theme.UCP2_PAMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    dospem1: List<String>,
    dospem2: List<String>,
    onSelection1Changed: (String) -> Unit,
    onSelection2Changed: (String) -> Unit,
    onSubmitButtonClick: (MutableList<String>) -> Unit,
){
    var namaTxt by rememberSaveable{
        mutableStateOf("")
    }
    var nimTxt by rememberSaveable{
        mutableStateOf("")
    }
    var konsentrasiTxt by rememberSaveable{
        mutableStateOf("")
    }
    var judulTxt by remember{
        mutableStateOf("")
    }

    var listDataTxt: MutableList<String> = mutableListOf(namaTxt, nimTxt, konsentrasiTxt, judulTxt)
    var dospem1YgDipilih by remember { mutableStateOf("") }
    var dospem2YgDipilih by remember { mutableStateOf("") }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        Text(text = "Formulir Pengajuan Skripsi", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = namaTxt,
            onValueChange = {namaTxt = it},
            label = {
                Text(text = "Nama Mahasiswa")
            }
        )
        OutlinedTextField(
            value = nimTxt,
            onValueChange = {nimTxt = it},
            label = {
                Text(text = "NIM")
            }
        )
        OutlinedTextField(
            value = konsentrasiTxt,
            onValueChange = {konsentrasiTxt = it},
            label = {
                Text(text = "Konsentrasi")
            }
        )
        OutlinedTextField(
            value = judulTxt,
            onValueChange = {judulTxt = it},
            label = {
                Text(text = "Judul Skripsi")
            }
        )
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))){
            Row (){
                dospem1.forEach{ item ->
                    Row (
                        modifier = Modifier.selectable(
                            selected = dospem1YgDipilih == item,
                            onClick = {
                                dospem1YgDipilih = item
                                onSelection1Changed(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            selected = dospem1YgDipilih == item,
                            onClick = {
                                dospem1YgDipilih = item
                                onSelection1Changed(item)
                            }
                        )
                        Text(item)
                    }
                }
                dospem2.forEach{ item ->
                    Row (
                        modifier = Modifier.selectable(
                            selected = dospem2YgDipilih == item,
                            onClick = {
                                dospem2YgDipilih = item
                                onSelection2Changed(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            selected = dospem2YgDipilih == item,
                            onClick = {
                                dospem2YgDipilih = item
                                onSelection2Changed(item)
                            }
                        )
                        Text(item)
                    }
                }
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ){
                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { onSubmitButtonClick(listDataTxt) }
                ) {
                    Text(stringResource(R.string.btn_submit))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanSatu() {
    UCP2_PAMTheme {
        HalamanSatu(
            dospem1 = listOf(),
            dospem2 = listOf(),
            onSelection1Changed = {},
            onSelection2Changed = {},
            onSubmitButtonClick = {})
    }
}