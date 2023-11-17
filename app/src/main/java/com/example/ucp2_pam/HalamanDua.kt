package com.example.ucp2_pam

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.ucp2_pam.data.OrderUIState

@Composable
fun HalamanDua(
    orderUIState: OrderUIState,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
    ){
    val  items = listOf(
        Pair(stringResource(R.string.dp1), orderUIState.dospem1),
        Pair(stringResource(R.string.dp2), orderUIState.dospem2)
    )

    Column (
        modifier = modifier,
        verticalArrangement =  Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            Text(text = "Nama Mahasiswa")
            Text(text = orderUIState.nama, fontWeight = FontWeight.Bold)
            Divider()
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Text(text = "NIM")
            Text(text = orderUIState.nim, fontWeight = FontWeight.Bold)
            Divider()
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Text(text = "Konsentrasi")
            Text(text = orderUIState.konsentrasi, fontWeight = FontWeight.Bold)
            Divider()
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Text(text = "Judul Skripsi")
            Text(text = orderUIState.judul, fontWeight = FontWeight.Bold)
            Divider()
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            items.forEach{ item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }
        Row (
            modifier = Modifier
                .weight(1f, false)
                .padding(dimensionResource(R.dimen.padding_medium))
        ){
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(stringResource(R.string.btn_back))
                }
            }
        }
    }