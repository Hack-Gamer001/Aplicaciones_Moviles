package com.example.g11_part2_anim_web_proyect_spiderman_2_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class navegacion : AppCompatActivity() {
    private lateinit var wv1: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegacion)

        wv1 = findViewById(R.id.wv1)

        // Habilitar JavaScript en WebView
        val webSettings: WebSettings = wv1.settings
        webSettings.javaScriptEnabled = true

        wv1.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                // Oculta el indicador de carga de la página
                title = ""
            }
        }

        wv1.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress == 100) {
                    // Página completamente cargada, muestra el título
                    title = view.title
                }
            }
        }

        val URL = intent.getStringExtra("URL") // Recibe el enlace URL

        if (!URL.isNullOrBlank()) {
            // Agregar "https://" si no se proporciona en el enlace
            if (!URL.startsWith("http://") && !URL.startsWith("https://")) {
                val finalURL = "https://$URL"
                wv1.loadUrl(finalURL)
            } else {
                wv1.loadUrl(URL)
            }
        } else {
            // Enlace vacío, puedes manejar esto como desees
            // Aquí muestro un mensaje de error en el WebView
            wv1.loadData("<html><body><h1>Error: Enlace vacío</h1></body></html>", "text/html", "utf-8")
        }
    }

    fun cerrar(view: View) {
        val intent = Intent(this, SplashActivity::class.java)
        startActivity(intent)
        finish()
    }
}
