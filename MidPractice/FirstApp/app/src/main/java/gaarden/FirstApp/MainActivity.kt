package gaarden.FirstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var buttonone: Button // 자료형이 Button
    lateinit var buttontwo: Button
    lateinit var buttonthree: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonone = findViewById<Button>(R.id.button1)
        buttonone.setOnClickListener {
            Toast.makeText(applicationContext,
            "안드로이드를 누르셨군요!",
            Toast.LENGTH_SHORT).show()
        } // 자바에서는 익명 클래스 역할

        buttontwo = findViewById<Button>(R.id.button2)
        buttontwo.setOnClickListener {
            Toast.makeText(applicationContext,
                "코틀린을 누르셨군요!",
                Toast.LENGTH_SHORT).show()
        } // 자바에서는 익명 클래스 역할

        buttonthree = findViewById<Button>(R.id.button3)
        buttonthree.setOnClickListener {
            Toast.makeText(applicationContext,
                "자바를 누르셨군요!",
                Toast.LENGTH_SHORT).show()
        } // 자바에서는 익명 클래스 역할
    }
}