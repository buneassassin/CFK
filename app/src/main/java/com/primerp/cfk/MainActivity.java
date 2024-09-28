package com.primerp.cfk;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        String resultado = "";

        if (temperatura instanceof C) {
            C celsius = (C) temperatura;
            resultado += "Fahrenheit: " + celsius.Parse(new F(0)) + "\n";
            resultado += "Kelvin: " + celsius.Parse(new K(0)) + "\n";
        } else if (temperatura instanceof F) {
            F fahrenheit = (F) temperatura;
            resultado += "Celsius: " + fahrenheit.Parse(new C(0)) + "\n";
            resultado += "Kelvin: " + fahrenheit.Parse(new K(0)) + "\n";
        } else if (temperatura instanceof K) {
            K kelvin = (K) temperatura;
            resultado += "Celsius: " + kelvin.Parse(new C(0)) + "\n";
            resultado += "Fahrenheit: " + kelvin.Parse(new F(0)) + "\n";
        }

        textViewResultado.setText(resultado);
    }
}