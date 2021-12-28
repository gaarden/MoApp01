package gaarden.Practice.Project7_1_2

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import java.io.FileInputStream

class MainActivity : AppCompatActivity() {

    lateinit var rotate: EditText
    lateinit var imageview: ImageView
    lateinit var layout: RelativeLayout
    lateinit var btn: Button
    lateinit var box1: Button
    lateinit var sdcard: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title="제주도 풍경 앱"
        rotate = findViewById(R.id.rotate)
        imageview = findViewById(R.id.imageview)
        layout = findViewById(R.id.layout)
        btn = findViewById(R.id.btn)
        registerForContextMenu(btn)

        box1 = findViewById(R.id.box1)

        box1.setOnClickListener{
            var dlg = AlertDialog.Builder(this@MainActivity)
            dlg.setTitle("제목")
            dlg.setMessage("내용")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setPositiveButton("확인", null)
            dlg.show()
        }

        sdcard = findViewById(R.id.sdcard)

        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
        Context.MODE_PRIVATE)

        sdcard.setOnClickListener{
            var inFs = FileInputStream("/sdcard/PictureTest/renoir01.png")

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var mInflater = menuInflater
        if (v === btn){
            menu!!.setHeaderTitle("버튼 속성")
            mInflater.inflate(R.menu.menu2, menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.rotate->{
                var siz: Int = Integer.parseInt(rotate.getText().toString())
                imageview.rotation = siz.toFloat()
                Toast.makeText(this, "${siz}만큼 그림을 회전했습니다.", Toast.LENGTH_SHORT).show()
            }

            R.id.item1->{
                imageview.setImageResource(R.drawable.jeju1)
            }

            R.id.item2->{
                imageview.setImageResource(R.drawable.jeju2)
            }

            R.id.item3->{
                imageview.setImageResource(R.drawable.jeju3)
            }

            R.id.colorRed->{
                layout.setBackgroundColor(Color.RED)
            }

            R.id.colorGreen->{
                layout.setBackgroundColor(Color.GREEN)
            }

            R.id.colorBlue->{
                layout.setBackgroundColor(Color.BLUE)
            }
        }

        return false
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.rotate->{
                btn.rotation=45f
                Toast.makeText(this, "버튼을 회전하였습니다", Toast.LENGTH_SHORT).show()
            }

            R.id.size->{
                btn.scaleX=2f
                btn.scaleY=2f
                Toast.makeText(this, "버튼을 가로, 세로 2배씩 확대했습니다", Toast.LENGTH_SHORT).show()
            }
        }


        return false
    }
}