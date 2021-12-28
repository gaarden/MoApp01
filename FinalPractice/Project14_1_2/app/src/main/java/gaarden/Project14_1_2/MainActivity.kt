package gaarden.Project14_1_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var soundIntent: Intent
    lateinit var btnStart: Button
    lateinit var btnStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        title = "서비스 테스트 예제(개선)"

        soundIntent = Intent(this, MusicService::class.java)
        btnStart = findViewById<Button>(R.id.btnStart)
        btnStop = findViewById<Button>(R.id.btnStop)

        btnStart.setOnClickListener {
            startService(soundIntent)
            Toast.makeText(applicationContext, "startService()", Toast.LENGTH_SHORT)
                .show()
            finish()
        }

        btnStop.setOnClickListener {
            stopService(soundIntent)
            Toast.makeText(applicationContext, "stopService()", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
