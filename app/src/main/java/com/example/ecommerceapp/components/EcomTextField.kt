package com.example.ecommerceapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.ui.theme.EcommerceAppTheme
import com.example.ecommerceapp.ui.theme.Typography

@Composable
fun EcomTextField(
    modifier: Modifier = Modifier,
    value : TextFieldValue = TextFieldValue(""),
    onValueChange : (TextFieldValue) -> Unit = {},
    label : String = "",
    error : String = "",
    isPasswordField: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: (Boolean) -> Unit = {}
){
    Column(
        modifier = modifier
    ){
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            placeholder = {
                Text(
                    text = "Enter your $label",
                    style = MaterialTheme.typography.labelMedium
                )
            },
            visualTransformation = if(isPasswordField && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            suffix = {
                if(isPasswordField){
                    Icon(
                        imageVector = if(!passwordVisible)Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = if(passwordVisible) "Show password" else "Hide password",
                        modifier = Modifier.clickable {
                            onPasswordVisibilityChange(!passwordVisible)
                        }
                    )
                }
            }
        )
        if(error.isNotEmpty()) {
            Text(
                text = error,
                color = Color.Red,
                fontSize = 12.sp,
            )
        }
    }
}

@Composable
@Preview
fun PreviewEcomTextField(){
    EcommerceAppTheme {
        EcomTextField()
    }
}