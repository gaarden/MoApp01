package gaarden.Practice.Project7_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var baseLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        baseLayout = findViewById(R.id.baseLayout)

        registerForContextMenu(btn1)
        registerForContextMenu(btn2)

        btn1.setOnClickListener{
            Toast.makeText(this, "okay google~, btn1.getText()하면 배경색 변경 뜬다", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v === btn1){
            menu.setHeaderTitle("배경색 변경")
            menu.add(0, 1, 0, "배경색 (빨강)")
            menu.add(0, 2, 0, "배경색 (초록)")
            menu.add(0, 3, 0, "배경색 (파랑)")

        }

        if (v === btn2) {
            menu.add(0, 4, 0, "버튼 45도 회전")
            menu.add(0, 5, 0, "버튼 2배 확대")
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            1->{
                baseLayout.setBackgroundColor(Color.RED)
                return true
            }

            2->{
                baseLayout.setBackgroundColor(Color.GREEN)
                return true
            }

            3->{
                baseLayout.setBackgroundColor(Color.BLUE)
                return true
            }

            4->{
                btn2.rotation = 45f
                return true
            }

            5->{
                btn2.scaleX = 2f
                return true
            }
        }

        return false
    }
}