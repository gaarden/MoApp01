package gaarden.Project13_2

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btn: Button
    lateinit var pb1: ProgressBar
    lateinit var pb2: ProgressBar
    lateinit var tv1: TextView
    lateinit var tv2: TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pb1 = findViewById<ProgressBar>(R.id.pb1)
        pb2 = findViewById<ProgressBar>(R.id.pb2)
        btn = findViewById<Button>(R.id.button1)

        tv1 = findViewById<TextView>(R.id.tv1)
        tv2 = findViewById<TextView>(R.id.tv2)

        btn.setOnClickListener {
            var thread1 = object: Thread(){
                override fun run() {
                    for(i in pb1.progress .. 99 ) {
                        pb1.progress = pb1.progress + 2
                        runOnUiThread {
                            pb1.progress = pb1.progress + 2
                            tv1.text = ("1번 진행률 : " + pb1.progress + "%")
                        }
                        SystemClock.sleep(100)
                    }
                }
            }

            var thread2 = object: Thread(){
                override fun run() {
                    for (i in pb2.progress..99) {
                        runOnUiThread {
                            pb2.progress = pb2.progress + 1
                            tv2.text = ("2번 진행률 : " + pb2.progress + "%")
                        }
                        SystemClock.sleep(25)
                    }
                }
            }

            thread1.start()
            thread2.start()
        }

    }
}

