package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
            }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   Column{
    FondoIma()
    BotonCalc()
    TFValor1()
    TFValor2()
}
}
@Composable
fun FondoIma() {
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = "Fondo",
        //modifier = Modifier.fillMaxWidth(),
        //alignment = Alignment.TopStart,
        //contentScale = ContentScale.FillWidth
    )
}
@Composable
fun BotonCalc() {
    Button(onClick = {
        //your onclick code
    },
        colors = ButtonDefaults.buttonColors(Color.DarkGray))
    {
        Text(text = "Calcular",color = Color.White)
    }
}
@Composable
fun TFValor1() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Valor 1") },
        onValueChange = {
            text = it
        }

    )
}
@Composable
fun TFValor2() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Valor 2") },
        onValueChange = {
            text = it
        }

    )
}