package com.example.atry.Presentation.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.atry.R

@Composable
fun Login(){
    var email=""
    var password = ""


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
                painter = painterResource(id = R.drawable.img),
                contentDescription = "")

            Spacer(modifier = Modifier.height(20.dp))


            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                enabled = true,
                value =email ,
                onValueChange ={email=it},
                placeholder = { Text(text = "Email Address")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,

                    )
            )

            TextField(
                enabled = true,
                value =password ,
                onValueChange ={password=it},
                placeholder = { Text(text = "password")},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,

                    )
            )


            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier =Modifier
                    .fillMaxWidth()
                , onClick = { /*TODO*/ }) {
                Text(text = "Login")
            }



        }

    }

}

@Composable
@Preview
fun Show(){
    Login()
}