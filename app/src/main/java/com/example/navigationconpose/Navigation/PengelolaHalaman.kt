package com.example.navigationconpose.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationconpose.ui.view.screen.MahasiswaFormView
import com.example.navigationconpose.ui.view.screen.RencanaStudyView
import com.example.navigationconpose.ui.view.screen.SplashView
import com.example.navigationconpose.ui.view.screen.TampilanMahasiswaView
import com.example.navigationconpose.ui.view.viewmodel.MahasiswaViewModel
import com.example.navigationconpose.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman{
    Splash,
    Mahasiswa,
    MataKuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    krsViewModel: RencanaStudyViewModel = viewModel()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val rencanaStudiUiState = krsViewModel.krsStateUi.collectAsState().value

    NavHost(
        navController = navController,
        startDestination =  Halaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Halaman.Splash.name){
            SplashView (
                onMulaiButton = {
                    navController.navigate(
                        Halaman.Mahasiswa.name
                    )
                }
            )
        }
        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView(
                onSubmitButton = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.MataKuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.MataKuliah.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {krsViewModel.saveDataKRS(it)
                    navController.navigate(Halaman.Tampil.name)
                                        },
                onBackButtonClicked = {navController.popBackStack()}
            )
        }

        composable(route = Halaman.Tampil.name){
            TampilanMahasiswaView(
                mhs = mahasiswaUiState ,
                rs = rencanaStudiUiState,
                onBackButtonClick = {navController.popBackStack()}
            )
        }
    }
}