package ipca.example.calculatorproject.ui.theme.Componente

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ipca.example.calculatorproject.CalculatorTheme
import ipca.example.calculatorproject.ui.theme.Purple40


@Composable
fun CalcButton(
    modifier: Modifier = Modifier,
    label : String = "",
    isOperation : Boolean = false,
    onClick : (String) -> Unit = {}
) {

    Button(
        modifier = modifier
            .aspectRatio(1f)
            .padding(4.dp),
        colors = if (isOperation)
            ButtonDefaults.run { buttonColors(Red) }
        else
            ButtonDefaults.run { buttonColors(Purple40) },
        onClick = {
            onClick(label)
        }) {
        Text(text = label,
            style = MaterialTheme.typography.bodyLarge)
    }

}

@Preview(showBackground = true)
@Composable
fun CalcButtonPreview() {
    CalculatorTheme {
        CalcButton(
            label = "7"
        )
    }
}