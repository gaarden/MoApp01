package gaarden.Class.Project10_1

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: Activity() {

    lateinit var btnReturn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.second_layout)

        btnReturn = findViewById(R.id.btnReturn)

        btnReturn.setOnClickListener{
            finish()
        }
    }
}