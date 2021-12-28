package gaarden.Practice.Project289

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var layout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title="배경색 바꾸기"
        layout = findViewById(R.id.layout)
        btn1 = findViewById(R.id.btn1)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemRed->{
                layout.setBackgroundColor(Color.RED)
                return true
            }

            R.id.itemGreen->{
                layout.setBackgroundColor(Color.GREEN)
                return true
            }

            R.id.itemBlue->{
                layout.setBackgroundColor(Color.BLUE)
                return true
            }

            R.id.subRotate->{
                btn1.rotation=45f
                return true
            }

            R.id.subSize->{
                btn1.scaleX=2f
                return true
            }
        }

        return false
    }
}