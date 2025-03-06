package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
        }
    }
}
@Composable
fun Content() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        FondoIma()
        val precio = tFNumero("Precio", "Ingrese el precio del producto")
        val descuento = tFNumero("Descuento (%)", "Ingrese el porcentaje de descuento")
        BotonCalc(precio, descuento)
    }
}

@Composable
fun FondoIma() {
    Image(
        painter = painterResource(id = R.drawable.mamalucha),
        contentDescription = "Fondo",
        modifier = Modifier.fillMaxWidth(),
        alignment = Alignment.TopStart,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun BotonCalc(precio: TextFieldValue, descuento: TextFieldValue) {
    var p by remember { mutableDoubleStateOf(0.0) }
    var d by remember { mutableDoubleStateOf(0.0) }
    var resultado by remember { mutableDoubleStateOf(0.0) }

    Button(
        modifier = Modifier.padding(16.dp),
        colors = ButtonDefaults.buttonColors(Color.LightGray),
        shape = RoundedCornerShape(20.dp),
        onClick = {
            p = precio.text.toDoubleOrNull() ?: 0.0
            d = descuento.text.toDoubleOrNull() ?: 0.0
            resultado = p - (p * d / 100)
        },
    ) {
        Text(text = "CALCULAR", color = Color.Black)
    }

    Text(
        text = "¡¡USTED PAGA!!: $resultado",
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(28.dp)
    )
}

@Composable
fun tFNumero(value: String, placeholder: String): TextFieldValue {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        modifier = Modifier.padding(16.dp),
        value = text,
        label = { Text(text = value, color = Color.Black) },
        placeholder = { Text(text = placeholder, color = Color.Gray) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it -> text = it },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color.Black,
            focusedBorderColor = Color.Black,
            focusedTextColor = Color.Black
        ),
    )
    return text
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    Content()
}
