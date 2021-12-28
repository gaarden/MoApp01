package knu.mobileapp.midterm1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout: LinearLayout

    lateinit var button1: Button
    lateinit var button8: Button

    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button8 = findViewById(R.id.button8)

        baseLayout = findViewById(R.id.baseLayout)

        text = findViewById(R.id.text)

        registerForContextMenu(button8)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu!!.add(0, 1, 0, "옵션 메뉴 1번")
        menu!!.add(0, 2, 0, "옵션 메뉴 2번")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{
                baseLayout.setBackgroundColor(Color.RED)
                return true
            }

            2->{
                button8.rotation = 45f
                return true
            }
        }
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v===button8){
            var mInflater = this.menuInflater
            mInflater.inflate(R.menu.menu1, menu)
        }

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.context1->{
                Toast.makeText(this, "헬로, 월드!", Toast.LENGTH_SHORT).show()
            }

            R.id.context2->{
                text.setTextColor(Color.BLUE)
            }
        }


        return false
    }
}