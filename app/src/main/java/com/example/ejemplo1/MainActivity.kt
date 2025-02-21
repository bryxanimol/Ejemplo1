package com.example.ejemplo1;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.setContent;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.res.painterResource;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.foundation.Image;
import androidx.compose.foundation.layout.Box;
import androidx.compose.foundation.layout.Column;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.Button;
import androidx.compose.material3.Text;
import androidx.compose.material3.TextField;
import androidx.compose.runtime.getValue;
import androidx.compose.runtime.mutableStateOf;
import androidx.compose.runtime.remember;
import androidx.compose.runtime.setValue;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.dp;
import androidx.compose.foundation.layout.*;
import androidx.compose.ui.Alignment;

import com.example.ejemplo1.ui.theme.Ejemplo1Theme;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1Theme {
                Content()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Content() {
    var valor by remember { mutableStateOf("") };
    var descuento by remember { mutableStateOf("") };
    var resultado by remember { mutableStateOf("") };

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Imagen();
        TextFieldInput("Valor 1", valor) { valor = it };
        TextFieldInput("Descuento (%)", descuento) { descuento = it };
        BotonCalcular(valor, descuento) { resultado = it };
        Text(text = "Precio con descuento: $resultado");
    }
}

@Composable
fun Imagen() {
    Box(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.25f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.oferta),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        );
    }
}

@Composable
fun TextFieldInput(label: String, value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = onValueChange,
        placeholder = { Text(text = "Ingresa $label") }
    );
}

@Composable
fun BotonCalcular(valor: String, descuento: String, onResult: (String) -> Unit) {
    Button(onClick = {
        val numValor = valor.toDoubleOrNull() ?: 0.0;
        val numDescuento = descuento.toDoubleOrNull() ?: 0.0;
        val precioFinal = numValor - (numValor * numDescuento / 100);
        onResult(precioFinal.toString());
    }) {
        Text(text = "Calcular");
    }
}