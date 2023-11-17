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
                dosen1 = pilihDospem1
            )
        }
    }

    fun setDospem2(pilihDospem2: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                dosen2 = pilihDospem2
            )
        }
    }
}