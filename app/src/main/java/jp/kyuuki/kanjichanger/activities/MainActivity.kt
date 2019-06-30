package jp.kyuuki.kanjichanger.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import jp.kyuuki.kanjichanger.R

import jp.kyuuki.kanjichanger.components.numberToKanji

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.edit_text_number)
        val textResultKanji = findViewById<TextView>(R.id.text_result_kanji)
        val buttonChange = findViewById<Button>(R.id.button_change)

        buttonChange.setOnClickListener {
            textResultKanji.text = numberToKanji(Integer.parseInt(editTextNumber.text.toString()))
        }
    }
}