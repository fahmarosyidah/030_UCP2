package com.example.ucp2_pam

import androidx.lifecycle.ViewModel
import com.example.ucp2_pam.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setDospem1(pilihDospem1: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                dospem1 = pilihDospem1
            )
        }
    }

    fun setDospem2(pilihDospem2: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                dospem2 = pilihDospem2
            )
        }
    }

    fun setContact(listData: MutableList<String>){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                nim = listData[1],
                konsentrasi = listData[2],
                judul = listData[3]
            )
        }
    }
}