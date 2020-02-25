package com.example.webviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.webkit.JavascriptInterface
import android.webkit.WebViewClient
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main)

        webview.apply {
            settings.javaScriptEnabled = true // 자바스크립트가 잘 동작하도록 설정
            webViewClient = WebViewClient() // 웹뷰에서 페이지가 뜨도록, 설정 안해주면 기본 브라우저가 실행됨.
        }

        webview.loadUrl("file:///android_asset/index.html")
        //webview.loadUrl("https://m.meatbox.co.kr")




        webview.addJavascriptInterface(JSInterface(), "JSInterface")



    }

    inner class JSInterface {

        @JavascriptInterface
        fun showDialog(text: String) {
            val dialog = AlertDialog.Builder(this@MainActivity)
                    .setMessage(text)
                    .create()
            dialog.show()
        }
    }
}


