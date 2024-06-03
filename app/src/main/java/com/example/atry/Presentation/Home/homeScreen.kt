package com.example.atry.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.atry.Presentation.Home.HomepageViewModel
import com.example.atry.data.model.UserInfo
import com.example.atry.util.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    val viewModel: HomepageViewModel = hiltViewModel()
    val state by viewModel.userList.collectAsState()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "All Registered User") }) }
    ) { paddingValues ->

        when(state){
            is UiState.Failure -> {
                Column (
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = "Something is wrong")
                }

            }
            UiState.Loading -> {
                Column (
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = "Loading..")
                }
            }
            is UiState.Success ->{
                val users = (state as UiState.Success<List<UserInfo>>).data
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp)
                .padding(paddingValues)
        ) {

                    items(users){ user ->
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = user.name)
                            Text(text = user.father)
                            Text(text = user.email)
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }

        }
    }
}