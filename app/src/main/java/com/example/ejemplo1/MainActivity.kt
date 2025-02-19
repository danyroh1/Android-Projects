package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    Box(
//       // modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
        Column {
            FondoIma()
            TFValor1()
            TFValor2()
            BotonCalc()
        }
    }
//}
@Composable
fun FondoIma() {
    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxWidth(),
        alignment = Alignment.TopStart,
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun BotonCalc() {
    Box(
        modifier = Modifier.padding(10.dp).fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Button(
            onClick = {
                //your onclick code
            },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
        ) {
            Text(text = "Calcular", color = Color.White)
        }
    }
}
@Composable
fun TFValor1() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Valor 1") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .padding(horizontal = 90.dp, vertical = 30.dp)
            .fillMaxWidth(1f),
        onValueChange = { it ->
            text = it
        }
    )
}

@Composable
fun TFValor2() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Valor 2") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .padding(horizontal = 90.dp, vertical = 25.dp)
            .fillMaxWidth(1f),
        onValueChange = { it ->
            text = it
        }
    )
}