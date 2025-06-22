package com.example.proyect_ganyu_anim_web_part1_g11_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edNombre, edClave, edPagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNombre = findViewById(R.id.ed1);
        edClave = findViewById(R.id.ed2);
        edPagina = findViewById(R.id.ed3);
    }

    public void navegar(View view) {
        String nombres = edNombre.getText().toString();
        String clave = edClave.getText().toString();
        String pagina = edPagina.getText().toString();

        if (!nombres.isEmpty() && !clave.isEmpty() && !pagina.isEmpty()) {
            // Verifica si la entrada en 'pagina' es una URL válida
            if (!pagina.startsWith("http://") && !pagina.startsWith("https://")) {
                pagina = "https://" + pagina;
            }

            Intent enviar = new Intent(this, navegacion.class);
            enviar.putExtra("vnonbres", nombres);
            enviar.putExtra("vclave", clave);
            enviar.putExtra("sitiolleb", pagina);
            enviar.putExtra("URL", pagina);
            startActivity(enviar);
        } else {
            edNombre.setError("Complete el nombre");
            edClave.setError("Complete la clave");
            edPagina.setError("Complete la página");
            Toast.makeText(getApplicationContext(), "No se puede ir a las Páginas Web", Toast.LENGTH_SHORT).show();
        }
    }
}
