package ipca.example.calculatorproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    displayTextColor: Color = Color.White,

) {
    //Ver valor na tela
    var displayValue by remember { mutableStateOf("0") }

    //Variáveis para guardar o valor anterior e a operação a realizar
    var previousValue by remember {mutableStateOf("")}

    var operation by remember {mutableStateOf("")}

    Column(
        modifier = modifier
            .padding(0.dp)
            .fillMaxSize()
            .background(Color(0xFF333333))
    ) {
        //Mostra o valor atual
        Text(
            text = displayValue,
            color = displayTextColor,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            maxLines = 1
        )

        //Função para atualizar o valor na tela
        fun onNumberClick(number: String) {
            if (displayValue == "0") {
                displayValue = number // Substitui o 0 pelo numero em que clicar
            } else {
                displayValue += number // Adiciona o número clicado ao valor atual
            }
        }
        //Função para inserir a vírgula
        fun onCommaClick() {
            if (!displayValue.contains(",")) {
                displayValue += ","
            }
        }

        //Função para realizar a operação
        fun onOperationClick(op: String) {
            previousValue = displayValue.replace(",", ".") // Converte a vírgula para ponto decimal
            displayValue ="0" // Limpa a tela
            operation = op
        }

        //Função para calcular o resultado
        fun onEqualsClick(){
            val prev = previousValue.toDoubleOrNull()
            val current = displayValue.replace(",", ".").toDoubleOrNull()

            if (prev != null && current != null) {
                when (operation) {
                    "+" -> displayValue = (prev + current).toString().replace(".",",")
                }
            }
        }



        Row{
            Button(
                onClick = {displayValue = "0"},  //Limpa o valor na tela
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C4C4C))
            ){
                Text(text="C", color = Color.White)
        }
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                       colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C4C4C))
            ){
                Text(text="+-", color = Color.White)

            }
            Button(
                onClick={},
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                      colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C4C4C))
            ){
                   Text(text="%", color = Color.White)
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                     colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9600))

            ){
                Text(text="/", color = Color.White)
            }

        }

        Row {
            Button(
                onClick = { onNumberClick("7") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "7", color = Color.White)
            }
            Button(
                onClick = { onNumberClick("8") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "8", color = Color.White)
            }
            Button(
                onClick = { onNumberClick("9") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "9", color = Color.White)
            }
            Button(
                onClick = { /* TODO: Implement multiplication logic */ },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9600))
            ) {
                Text(text = "x", color = Color.White)
            }
        }

        Row {
            Button(
                onClick = { onNumberClick("4") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "4", color = Color.White)
            }
            Button(
                onClick = { onNumberClick("5") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "5", color = Color.White)
            }
            Button(
                onClick = { onNumberClick("6") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "6", color = Color.White)
            }
            Button(
                onClick = { /* TODO: Implement subtraction logic */ },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9600))
            ) {
                Text(text = "-", color = Color.White)
            }
        }

        Row {
            Button(
                onClick = { onNumberClick("1") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "1", color = Color.White)
            }
            Button(
                onClick = { onNumberClick("2") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "2", color = Color.White)
            }
            Button(
                onClick = { onNumberClick("3") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "3", color = Color.White)
            }
            Button(
                onClick = { /* TODO*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9600))
            ) {
                Text(text = "+", color = Color.White)
            }
        }

        Row {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "J", color = Color.White)
            }
            Button(
                onClick = { onNumberClick("0") },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = "0", color = Color.White)
            }
            Button(
                onClick = { onCommaClick()}, // Para chamar a função da vírgula
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3C3C3C))
            ) {
                Text(text = ",", color = Color.White)
            }
            Button(
                onClick = { /* TODO*/ },
                modifier = Modifier
                    .padding(8.dp)
                    .size(64.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9600))
            ) {
                Text(text = "=", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatorTheme {
        CalculatorScreen()
    }
}
