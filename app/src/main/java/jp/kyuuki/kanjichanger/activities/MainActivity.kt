package jp.kyuuki.kanjichanger.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import jp.kyuuki.kanjichanger.R
import jp.kyuuki.kanjichanger.models.KanjiChangeableNumber
import java.math.BigInteger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.edit_text_number)
        val textResultKanji = findViewById<TextView>(R.id.text_result_kanji)
        val buttonConvert = findViewById<Button>(R.id.button_convert)
        val buttonClear = findViewById<Button>(R.id.button_clear)

        buttonConvert.setOnClickListener {
            try {
                val number = BigInteger(editTextNumber.text.toString())
                val kanjiChangeableNumber = KanjiChangeableNumber(number)
                textResultKanji.text = kanjiChangeableNumber.getKanji()
            } catch (e: NumberFormatException) {
                Log.e("MainActivity", e.toString())
                Toast.makeText(applicationContext, getString(R.string.message_invalid_input_number), Toast.LENGTH_LONG).show()
            }
        }

        buttonClear.setOnClickListener {
            editTextNumber.text = null
            textResultKanji.text = null
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }

            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
