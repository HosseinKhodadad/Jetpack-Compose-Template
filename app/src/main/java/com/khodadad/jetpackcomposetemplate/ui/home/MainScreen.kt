package com.khodadad.jetpackcomposetemplate.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.khodadad.jetpackcomposetemplate.data.model.ExampleModel
import com.khodadad.jetpackcomposetemplate.data.model.Resource

@Composable
fun MainScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    val dataState =
        remember { mutableStateOf<Resource<List<ExampleModel>>>(Resource.Loading) }
    val data = dataState.value

    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

    when (data) {
        is Resource.Loading -> {
            LoadingView()
        }

        is Resource.Success -> {
            val dataList = data.data
//            SuccessView(dataList)
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Data List",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Column(modifier = Modifier.fillMaxWidth()) {
//                    dataList.forEach { data ->
//                        Text(
//                            text = data.title,
//                            style = TextStyle(fontSize = 16.sp),
//                            modifier = Modifier.padding(bottom = 8.dp)
//                        )
//                    }
                }
            }
        }

        is Resource.Error -> {
            val errorMessage = data.errorMessage
            ErrorView(errorMessage)
        }
    }

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//
//        Text(
//            text = "Main Activity",
//            fontSize = 24.sp
//        )
//
//        Spacer(modifier = Modifier.size(40.dp))
//
//        Button(onClick = {
//            navController.navigate(Screen.Detail.route)
//        }) {
//            Text(text = "Go to Detail")
//        }
//    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun SuccessView(dataList: List<ExampleModel>) {

}

@Composable
fun ErrorView(errorMessage: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Error: $errorMessage",
            style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
            color = Color.Red
        )
    }
}
