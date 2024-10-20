package com.example.ecommerceapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ecommerceapp.R
import com.example.ecommerceapp.screens.home.components.EcomSearchBar
import com.example.ecommerceapp.screens.home.components.ImageSlider
import com.example.ecommerceapp.ui.theme.DarkBlue

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ){
        Icon(
            tint = DarkBlue,
            painter = painterResource(id = R.drawable.route_ic),
            contentDescription = stringResource(
                R.string.route_icon
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            EcomSearchBar(
                modifier = Modifier.weight(1f)
            )

            Icon(
                modifier = Modifier.padding(start = 32.dp),
                tint = DarkBlue,
                painter = painterResource(id = R.drawable.cart_ic),
                contentDescription = "Cart Icon"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ImageSlider()


    }
}

@Composable
@Preview
fun PreviewHomeScreen(){
    HomeScreen()
}