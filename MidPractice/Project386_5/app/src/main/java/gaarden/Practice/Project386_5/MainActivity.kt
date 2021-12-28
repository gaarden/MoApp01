package gaarden.Practice.Project386_5

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var btnPrev : Button
    lateinit var btnNext : Button
    lateinit var myPicture : myPictureView
    lateinit var tvNumber : TextView
    var curNum : Int = 0
    var imageFiles : Array<File>? = null
    var imageFname : String? = null

    companion object {
        var sX = 1f
        var sY = 1f
        var angle = 0f
        var color = 1f
        var satur = 1f
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 이미지 뷰어 (변경 및 사진 편집)"
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        tvNumber = findViewById(R.id.tvNumber)
        myPicture = findViewById(R.id.mpv)

        registerForContextMenu(myPicture)

        imageFiles = File(Environment.getExternalStorageDirectory().absolutePath + "/PictureTest").listFiles()
        imageFname = imageFiles!![0].toString()
        myPicture.imagePath = imageFname
        tvNumber.text = "1" + "/" + imageFiles!!.size

        btnPrev.setOnClickListener {
            if (curNum <= 0) {
                curNum = imageFiles!!.size - 1
            } else {
                curNum--
            }
            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath = imageFname
            myPicture.invalidate()
            tvNumber.text = (curNum + 1).toString() + "/" + imageFiles!!.size
        }

        btnNext.setOnClickListener {
            if (curNum >= imageFiles!!.size - 1) {
                curNum = 0
            } else {
                curNum++
            }
            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath = imageFname
            myPicture.invalidate()
            tvNumber.text = (curNum + 1).toString() + "/" + imageFiles!!.size
        }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        var mInflater = this.menuInflater
        mInflater.inflate(R.menu.menu1, menu)

        //kt로만 짜는거는 직접풀어보기7-2파일 참고
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.zi->{
                sX = sX + 0.2f
                sY = sY + 0.2f
                myPicture.invalidate()
            }

            R.id.zo->{
                sX = sX - 0.2f
                sY = sY - 0.2f
                myPicture.invalidate()
            }

            R.id.ro->{
                angle = angle + 20
                myPicture.invalidate()
            }

            R.id.br->{
                color = color + 0.2f
                myPicture.invalidate()
            }

            R.id.da->{
                color = color - 0.2f
                myPicture.invalidate()
            }

            R.id.gr->{
                if (satur == 0f)
                    satur = 1f
                else
                    satur = 0f
                myPicture.invalidate()
            }
        }

        return false
    }
}
