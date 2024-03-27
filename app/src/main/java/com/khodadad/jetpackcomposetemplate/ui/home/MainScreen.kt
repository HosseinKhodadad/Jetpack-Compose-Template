package com.khodadad.jetpackcomposetemplate.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.khodadad.jetpackcomposetemplate.navigation.Screen

@Composable
fun MainScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Main Activity",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.size(40.dp))

        Button(onClick = {
            navController.navigate(Screen.Detail.route)
        }) {
            Text(text = "Go to Detail")
        }
    }
}
