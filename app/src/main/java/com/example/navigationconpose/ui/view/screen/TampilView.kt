package com.example.navigationconpose.ui.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigationconpose.model.Mahasiswa
import com.example.navigationconpose.model.RencanaStudi

@Composable
fun TampilanMahasiswaView(
    mhs: Mahasiswa,
    rs : RencanaStudi,
    onBackClick: () -> Unit
){
    Column (modifier = Modifier.padding().fillMaxSize()){


        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {
            Text("Kembali")
        }

    }
}



