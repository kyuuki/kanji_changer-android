package jp.kyuuki.kanjichanger.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import jp.kyuuki.kanjichanger.BuildConfig
import jp.kyuuki.kanjichanger.R

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val textVersion = findViewById<TextView>(R.id.text_version)
        textVersion.setText("Ver." + BuildConfig.VERSION_NAME)
    }
}
