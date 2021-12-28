package knu.mobileapp.practice.Project394

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "메인 액티비티 (수정)"

        var rdoSecond = findViewById<RadioButton>(R.id.rdoSecond)

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        btnNewActivity.setOnClickListener {
            var intent: Intent

            if (rdoSecond.isChecked == true)
                intent = Intent(applicationContext,
                    SecondActivity::class.java)
            else
                intent = Intent(applicationContext,
                    ThirdActivity::class.java)

            startActivity(intent)
        }
    }

}