package knu.mobileapp.finalexam1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        title = "Second 액티비티"

        var result: TextView
        var btnresult: Button
        var btnclose: Button

        result = findViewById(R.id.result)
        btnresult = findViewById(R.id.btnresult)
        btnclose = findViewById(R.id.btnclose)

        btnclose.setOnClickListener{
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }

        btnresult.setOnClickListener{
            var value = intent.getStringExtra("plus")
            result.text = value
        }
    }
}