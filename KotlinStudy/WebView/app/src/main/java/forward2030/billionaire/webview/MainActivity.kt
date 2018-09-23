package forward2030.billionaire.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com")

        btn_naver.setOnClickListener {
            webView.loadUrl("https://www.naver.com")
        }

        btn_daum.setOnClickListener {
            webView.loadUrl("https://www.daum.net")
        }

        btm_google.setOnClickListener {
            webView.loadUrl("https://www.google.com")
        }
    }
}
