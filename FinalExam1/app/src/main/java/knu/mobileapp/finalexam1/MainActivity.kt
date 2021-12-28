package knu.mobileapp.finalexam1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="FinalExamProject1"

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)
        btnNewActivity.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)

            var intent = Intent(this, SecondActivity::class.java)
            var num1 = Integer.parseInt(edtNum1.text.toString())
            var num2 = Integer.parseInt(edtNum2.text.toString())
            var plus: Int = num1 + num2
            intent.putExtra("plus", plus.toString())
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK)
            Toast.makeText(applicationContext, "Goodbye!", Toast.LENGTH_SHORT).show()
    }
}