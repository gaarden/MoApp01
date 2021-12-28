package knu.mobileapp.finalexam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var bar1: ProgressBar
    lateinit var bar2: ProgressBar
    lateinit var text1: TextView
    lateinit var text2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bar1 = findViewById(R.id.bar1)
        bar2 = findViewById(R.id.bar2)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)

        button1.setOnClickListener {
            var thread1 = object: Thread(){
                override fun run() {
                    for (i in 0..10) {
                        for (i in 0..100) {
                            bar1.progress += 1
                            runOnUiThread{
                                bar1.progress += 1
                                text1.text = "First Runner: " + bar1.progress + ""
                            }
                            SystemClock.sleep(10)
                        }
                        SystemClock.sleep(100)
                    }
                }
            }

            var thread2 = object: Thread(){
                override fun run() {
                    for (i in 0..10) {
                        for (i in 0..100) {
                            bar2.progress += 1
                            runOnUiThread{
                                bar2.progress += 1
                                text2.text = "Second Runner: " + bar2.progress + ""
                            }
                            SystemClock.sleep(20)
                        }
                        SystemClock.sleep(200)
                    }
                }
            }

            thread1.start()
            thread2.start()
        }

        button2.setOnClickListener{
            bar1.progress = 0
            bar2.progress = 0
        }
    }


}