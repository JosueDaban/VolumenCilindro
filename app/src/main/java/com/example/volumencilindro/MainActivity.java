package com.example.volumencilindro;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRadioCilindro, editTextAlturaCilindro;
    private EditText editTextLargoParalelepipedo, editTextAnchoParalelepipedo, editTextAlturaParalelepipedo;
    private Button buttonCalcularCilindro, buttonCalcularParalelepipedo;
    private TextView textViewResultadoCilindro,textViewResultadoParalele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular los componentes de la UI con las variables
        editTextRadioCilindro = findViewById(R.id.editTextRadioCilindro);
        editTextAlturaCilindro = findViewById(R.id.editTextAlturaCilindro);
        editTextLargoParalelepipedo = findViewById(R.id.editTextLargoParalelepipedo);
        editTextAnchoParalelepipedo = findViewById(R.id.editTextAnchoParalelepipedo);
        editTextAlturaParalelepipedo = findViewById(R.id.editTextAlturaParalelepipedo);
        buttonCalcularCilindro = findViewById(R.id.buttonCalcularCilindro);
        buttonCalcularParalelepipedo = findViewById(R.id.buttonCalcularParalelepipedo);
        textViewResultadoCilindro = findViewById(R.id.textViewResultadoCilindro);
        textViewResultadoParalele = findViewById(R.id.textViewResultadoParalele);

        // Configurar el evento click del botón del cilindro
        buttonCalcularCilindro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularVolumenCilindro();
            }
        });

        // Configurar el evento click del botón del paralelepípedo
        buttonCalcularParalelepipedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularVolumenParalelepipedo();
            }
        });
    }

    private void calcularVolumenCilindro() {
        // Obtener los valores ingresados por el usuario
        String radioStr = editTextRadioCilindro.getText().toString();
        String alturaStr = editTextAlturaCilindro.getText().toString();

        // Verificar que los campos no estén vacíos
        if (radioStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese ambos valores para el cilindro", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertir los valores a double
        double radio = Double.parseDouble(radioStr);
        double altura = Double.parseDouble(alturaStr);

        // Calcular el volumen del cilindro (V = π * r² * h)
        double volumen = Math.PI * Math.pow(radio, 2) * altura;

        // Mostrar el resultado
        textViewResultadoCilindro.setText("Volumen del cilindro: " + String.format("%.2f", volumen));
    }

    private void calcularVolumenParalelepipedo() {
        // Obtener los valores ingresados por el usuario
        String largoStr = editTextLargoParalelepipedo.getText().toString();
        String anchoStr = editTextAnchoParalelepipedo.getText().toString();
        String alturaStr = editTextAlturaParalelepipedo.getText().toString();

        // Verificar que los campos no estén vacíos
        if (largoStr.isEmpty() || anchoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese todos los valores para el paralelepípedo", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertir los valores a double
        double largo = Double.parseDouble(largoStr);
        double ancho = Double.parseDouble(anchoStr);
        double altura = Double.parseDouble(alturaStr);

        // Calcular el volumen del paralelepípedo (V = largo * ancho * altura)
        double volumen = largo * ancho * altura;

        // Mostrar el resultado
        textViewResultadoParalele.setText("Volumen del paralelepípedo: " + String.format("%.2f", volumen));
    }
}