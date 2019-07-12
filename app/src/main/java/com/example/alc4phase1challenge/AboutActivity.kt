package com.example.alc4phase1challenge

import android.content.DialogInterface
import android.net.http.SslError
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity;
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.content_about.*

class AboutActivity : AppCompatActivity() {

    private val url: String = "https://andela.com/alc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setSupportActionBar(toolbar)

        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                val mAlertDialog = AlertDialog.Builder(this@AboutActivity)

                mAlertDialog.setMessage("SSL Error occurred. Continue to $url?")

                mAlertDialog.setPositiveButton("Continue", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        handler!!.proceed()
                    }

                })

                mAlertDialog.setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        handler!!.cancel()
                    }

                })

                mAlertDialog.show()

            }

        }

        webView.loadUrl(url)
    }

}
