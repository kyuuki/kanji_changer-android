package jp.kyuuki.kanjichanger.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import jp.kyuuki.kanjichanger.R
import jp.kyuuki.kanjichanger.models.KanjiChangeableNumber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.edit_text_number)
        val textResultKanji = findViewById<TextView>(R.id.text_result_kanji)
        val buttonConvert = findViewById<Button>(R.id.button_convert)
        val buttonClear = findViewById<Button>(R.id.button_clear)

        buttonConvert.setOnClickListener {
            // TODO: 数字以外が入力された場合の対応
            val number = KanjiChangeableNumber(editTextNumber.text.toString().toLong())
            textResultKanji.text = number.getKanji()
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
                //Toast.makeText(applicationContext, "TODO", Toast.LENGTH_LONG).show()
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
