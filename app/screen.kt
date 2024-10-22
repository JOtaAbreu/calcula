package ipca.example.calculatorproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ipca.example.calculatorproject.ui.theme.CalculatorProjectTheme




@Composable
fun CalculatorScreen(modifier:Modifier=Modifier){
    Column{
        Text(text ="0")
        Row{
            Buttom(onClick={/*TODO*/}){
                Text(text= "7")
            }
            Buttom(onClick={/*TODO*/}){
                Text(text= "8")
            }
        }
    }
}