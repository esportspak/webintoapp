package com.webintoapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private RelativeLayout mSplashScreen;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Handle Status Bar visibility based on AppConfig
        if (!AppConfig.SHOW_STATUS_BAR) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                               WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.webView);
        mSplashScreen = findViewById(R.id.splashScreen);

        setupWebView();
        handleSplashScreen();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView() {
        WebSettings webSettings = mWebView.getSettings();

        // Apply settings from AppConfig
        webSettings.setJavaScriptEnabled(AppConfig.ENABLE_JAVASCRIPT);
        webSettings.setDomStorageEnabled(AppConfig.ENABLE_DOM_STORAGE);
        webSettings.setBuiltInZoomControls(AppConfig.ENABLE_ZOOM_CONTROLS);
        webSettings.setDisplayZoomControls(false);

        // Apply Cache Mode
        switch (AppConfig.CACHE_MODE) {
            case 1: webSettings.setCacheMode(WebSettings.LOAD_CACHE_ONLY); break;
            case 2: webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); break;
            default: webSettings.setCacheMode(WebSettings.LOAD_DEFAULT); break;
        }

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(AppConfig.URL_TO_LOAD);
    }

    private void handleSplashScreen() {
        if (AppConfig.SHOW_SPLASH_SCREEN) {
            mSplashScreen.setVisibility(View.VISIBLE);
            mWebView.setVisibility(View.GONE);

            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                mSplashScreen.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);
            }, AppConfig.SPLASH_SCREEN_DURATION);
        } else {
            mSplashScreen.setVisibility(View.GONE);
            mWebView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
