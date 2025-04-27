package com.example.sigetec

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webview: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview = findViewById(R.id.webview)
        webview.webViewClient = WebViewClient()
        webview.webChromeClient = WebChromeClient() // Para alertas JS e vídeos

        webview.settings.javaScriptEnabled = true
        webview.settings.domStorageEnabled = true // Para sites modernos

        if (savedInstanceState == null) {
            webview.loadUrl("https://app.istfranca.com.br/app/sigetec-v-1-2-mobile/home-page-680a2ce72f459b503b7bee95")
        } else {
            webview.restoreState(savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webview.saveState(outState)
    }

    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
