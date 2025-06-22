package com.example.proyect_ganyu_anim_web_part1_g11_java;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

public class navegacion extends AppCompatActivity {
    WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegacion);

        wv1 = findViewById(R.id.wv1);

        // Habilitar JavaScript en WebView
        WebSettings webSettings = wv1.getSettings();
        webSettings.setJavaScriptEnabled(true);

        wv1.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // Oculta el indicador de carga de la página
                setTitle("");
            }
        });

        wv1.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    // Página completamente cargada, muestra el título
                    setTitle(view.getTitle());
                }
            }
        });

        String URL = getIntent().getStringExtra("URL"); // Recibe el enlace URL

        if (URL != null && !URL.isEmpty()) {
            // Agregar "https://" si no se proporciona en el enlace
            if (!URL.startsWith("http://") && !URL.startsWith("https://")) {
                URL = "https://" + URL;
            }
            wv1.loadUrl(URL);
        } else {
            // Enlace vacío, puedes manejar esto como desees
            // Aquí muestro un mensaje de error en el WebView
            wv1.loadData("<html><body><h1>Error: Enlace vacío</h1></body></html>", "text/html", "utf-8");
        }
    }

    public void cerrar(View view) {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        finish();
    }

}


