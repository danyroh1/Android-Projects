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
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                GreetingPreview()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview(){
    Content()

}

@Composable
fun Content(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        FondoIma()
        val numero1 = tFNumero("Valor 1", "Ingrese el primer valor")
        val numero2 = tFNumero("Valor 2", "Ingrese el segundo valor")
        BotonCalc(numero1, numero2)
    }
}
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
fun BotonCalc(numero1: TextFieldValue, numero2: TextFieldValue) {
    var n1 by remember { mutableIntStateOf(0) }
    var n2 by remember { mutableIntStateOf(0) }
    var resultado by remember { mutableIntStateOf(0) }

    Button(
        modifier = Modifier.padding(16.dp),
        colors = ButtonDefaults.buttonColors(Color.LightGray),
        shape = RoundedCornerShape(20.dp),
        onClick = {
            n1 = numero1.text.toIntOrNull() ?: 0
            n2 = numero2.text.toIntOrNull() ?: 0
            resultado = n1 + n2
        },
    ) {
        Text(text = "CALCULAR", color = Color.Black)
    }

    Text(
        text = "Resultado: $resultado",
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(28.dp)
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