package com.example.volumencilindro;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRadio, editTextAltura;
    private Button buttonCalcular;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextRadio = findViewById(R.id.editTextRadio);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        // Evento click del botón
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularVolumen();
            }
        });
    }

    private void calcularVolumen() {
        String radioStr = editTextRadio.getText().toString();
        String alturaStr = editTextAltura.getText().toString();

        if (radioStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese ambos valores", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convertir los valores a double
        double radio = Double.parseDouble(radioStr);
        double altura = Double.parseDouble(alturaStr);

        // Calcular el volumen del cilindro (V = π * r² * h)
        double volumen = Math.PI * Math.pow(radio, 2) * altura;

        // Mostrar el resultado
        textViewResultado.setText("Resultado: " + String.format("%.2f", volumen));
    }
}