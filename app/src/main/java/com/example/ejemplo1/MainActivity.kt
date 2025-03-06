package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
    Content("Hola", "Mundo")

}
@Composable
fun Content(mensaje1:String,mensaje2:String)
{
    Column {
        Text(mensaje1
            , fontSize = 15.sp)
        Text(mensaje2
            , lineHeight = 25.sp)
        Text("Dante"
            , fontWeight = FontWeight.Bold
            , fontSize = 30.sp
            , lineHeight = 32.sp)
    }
}