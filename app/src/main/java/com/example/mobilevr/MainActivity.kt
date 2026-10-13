package com.example.mobilevr

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : Activity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the title bar and set to fullscreen for VR
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Keep the screen on while in VR
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        // Create and set up the WebView
        val webView = WebView(this)
        setContentView(webView)

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            allowFileAccess = true
        }

        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        // Load the HTML file from the assets folder
        webView.loadUrl("file:///android_asset/index.html")
    }
}