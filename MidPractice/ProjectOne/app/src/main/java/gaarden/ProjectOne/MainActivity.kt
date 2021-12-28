package gaarden.ProjectOne

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tv1: TextView // 자료형이 Button
    lateinit var tv2: TextView
    lateinit var tv3: TextView

    lateinit var edit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById<TextView>(R.id.TextView1)
        tv1.setText("안녕")
        tv1.setOnClickListener{tv1.setText(R.string.text1)}

        tv2 = findViewById<TextView>(R.id.TextView2)
        tv2.setText("코틀린")

        tv3 = findViewById<TextView>(R.id.TextView3)
        tv3.setText("안드로이드")

        edit = findViewById<EditText>(R.id.edittext)


        tv3.setOnClickListener{
            var txt: String = edit.getText().toString()
            Toast.makeText(applicationContext, txt, Toast.LENGTH_SHORT).show()
        }
    }
}
