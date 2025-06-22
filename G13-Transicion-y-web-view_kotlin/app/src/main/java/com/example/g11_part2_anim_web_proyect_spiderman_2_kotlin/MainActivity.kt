package com.example.g11_part2_anim_web_proyect_spiderman_2_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edNombre: EditText
    private lateinit var edClave: EditText
    private lateinit var edPagina: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNombre = findViewById(R.id.ed1)
        edClave = findViewById(R.id.ed2)
        edPagina = findViewById(R.id.ed3)

        // Auto llenar los campos con valores específicos
        edNombre.setText("VENOM")
        edClave.setText("We Are Venom")
        edPagina.setText("goo.su/QWfjP")
    }

    fun navegar(view: View) {
        val nombres = edNombre.text.toString()
        val clave = edClave.text.toString()
        var pagina = edPagina.text.toString()

        if (nombres.isNotEmpty() && clave.isNotEmpty() && pagina.isNotEmpty()) {
            // Verifica si la entrada en 'pagina' es una URL válida
            if (!pagina.startsWith("http://") && !pagina.startsWith("https://")) {
                pagina = "https://$pagina"
            }

            val enviar = Intent(this, navegacion::class.java)
            enviar.putExtra("vnonbres", nombres)
            enviar.putExtra("vclave", clave)
            enviar.putExtra("sitiolleb", pagina)
            enviar.putExtra("URL", pagina)
            startActivity(enviar)
        } else {
            edNombre.setError("Complete el nombre")
            edClave.setError("Complete la clave")
            edPagina.setError("Complete la página")
            Toast.makeText(applicationContext, "No se puede ir a las Páginas Web", Toast.LENGTH_SHORT).show()
        }
    }
}
