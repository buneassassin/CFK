package com.primerp.cfk;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCantidad;
    private Spinner spinnerUnidad;
    private Button btnConvertir;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos de la UI
        editTextCantidad = findViewById(R.id.editTextCantidad);
        spinnerUnidad = findViewById(R.id.spinnerUnidad);
        btnConvertir = findViewById(R.id.btnConvertir);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Listener del botón para realizar la conversión
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados
                String cantidadTexto = editTextCantidad.getText().toString();
                if (cantidadTexto.isEmpty()) {
                    textViewResultado.setText("Por favor, ingrese una cantidad válida.");
                    return;
                }

                double cantidad = Double.parseDouble(cantidadTexto);
                String unidadSeleccionada = spinnerUnidad.getSelectedItem().toString();

                // Instanciar las clases según la unidad seleccionada
                Temperatura temperatura = null;

                switch (unidadSeleccionada) {
                    case "Celsius":
                        temperatura = new C(cantidad);
                        break;
                    case "Fahrenheit":
                        temperatura = new F(cantidad);
                        break;
                    case "Kelvin":
                        temperatura = new K(cantidad);
                        break;
                }

                // Mostrar el resultado de la conversión
                mostrarResultado(temperatura);
            }
        });

    }

    // Función para mostrar los resultados de la conversión
    private void mostrarResultado(Temperatura temperatura) {
        StringBuilder resultado = new StringBuilder();

        if (temperatura instanceof C) {
            C celsius = (C) temperatura;
            C fahrenheit = celsius.Parse(new F(celsius.getCantidad())); // Conversión a Fahrenheit
            C kelvin = celsius.Parse(new K(celsius.getCantidad()));     // Conversión a Kelvin
            resultado.append("Fahrenheit: ").append(fahrenheit.getCantidad()).append("\n");
            resultado.append("Kelvin: ").append(kelvin.getCantidad()).append("\n");
        } else if (temperatura instanceof F) {
            F fahrenheit = (F) temperatura;
            F celsius = fahrenheit.Parse(new C(fahrenheit.getCantidad())); // Conversión a Celsius
            F kelvin = fahrenheit.Parse(new K(fahrenheit.getCantidad()));  // Conversión a Kelvin
            resultado.append("Celsius: ").append(celsius.getCantidad()).append("\n");
            resultado.append("Kelvin: ").append(kelvin.getCantidad()).append("\n");
        } else if (temperatura instanceof K) {
            K kelvin = (K) temperatura;
            K celsius = kelvin.Parse(new C(kelvin.getCantidad()));     // Conversión a Celsius
            K fahrenheit = kelvin.Parse(new F(kelvin.getCantidad()));  // Conversión a Fahrenheit
            resultado.append("Celsius: ").append(celsius.getCantidad()).append("\n");
            resultado.append("Fahrenheit: ").append(fahrenheit.getCantidad()).append("\n");
        }

        textViewResultado.setText(resultado.toString());
    }
}
