package com.example.atry.Presentation.CreateAccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.atry.R
import com.example.atry.util.UiState

@Composable
fun CreateAccount(){
    var name by remember{ mutableStateOf("") }
    var email by remember{ mutableStateOf("") }
    var lname by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }
    var isShowingProgress by remember { mutableStateOf(false) }

    val viewModel:UserViewModel= hiltViewModel()
    val state by viewModel.isAdded.collectAsState(UiState.Loading)

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ){
        Column(

            modifier = Modifier
                .padding(horizontal = 25.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "")

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                modifier = Modifier.border(1.dp,MaterialTheme.colorScheme.inverseOnSurface),
                value =name ,
                onValueChange ={name=it},
                placeholder = { Text(text = "First name")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent

                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                modifier = Modifier.border(1.dp,MaterialTheme.colorScheme.inverseOnSurface),
                value =lname ,
                onValueChange ={lname=it},
                placeholder = { Text(text = "Last name")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                modifier = Modifier.border(1.dp,MaterialTheme.colorScheme.inverseOnSurface),
                value =email ,
                onValueChange ={email=it},
                placeholder = { Text(text = "Email Address")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent

                    )
            )

            TextField(
                modifier = Modifier.border(1.dp,MaterialTheme.colorScheme.inverseOnSurface),
                value =password ,
                onValueChange ={password=it},
                placeholder = { Text(text = "password")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent

                    )
            )


            Spacer(modifier = Modifier.height(10.dp))
            Button(
                enabled = !isShowingProgress,
                modifier =Modifier
                    .fillMaxWidth()
                , onClick = {
                    isShowingProgress = true
                    viewModel.addUser(
                    name = name,
                    father = lname,
                    email = email,
                    password = password)}) {



                    Text(text = "Create")

            }
            if(isShowingProgress){
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )
            }





        }

    }

}

@Composable
@Preview
fun Create(){
    CreateAccount()
}