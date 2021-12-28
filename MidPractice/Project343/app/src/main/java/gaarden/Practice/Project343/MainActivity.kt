package gaarden.Practice.Project343

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var btnPrev: Button
    lateinit var btnNext: Button
    lateinit var myPicture: myPictureView
    var curNum: Int = 0
    var imageFiles: Array<File>? = null
    lateinit var imageFname: String
    lateinit var page: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title="간단 이미지 뷰어"
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
        Context.MODE_PRIVATE)

        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        myPicture = findViewById(R.id.myPictureView1)

        imageFiles = File(Environment.getExternalStorageDirectory().absolutePath+"/PictureTest").listFiles()
        imageFname = imageFiles!![0].toString()
        myPicture.imagePath = imageFname

        page = findViewById(R.id.page)
        page.setText("${curNum+1}/${imageFiles!!.size}")

        btnPrev.setOnClickListener{
            if (curNum<=0){
                curNum = imageFiles!!.size-1
            }
            else{
                curNum--
            }
            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath = imageFname
            myPicture.invalidate()
            page.setText("${curNum+1}/${imageFiles!!.size}")

        }

        btnNext.setOnClickListener{
            if (curNum>=imageFiles!!.size-1){
                curNum = 0
            }
            else{
                curNum++
            }
            imageFname = imageFiles!![curNum].toString()
            myPicture.imagePath = imageFname
            myPicture.invalidate()
            page.setText("${curNum+1}/${imageFiles!!.size}")

        }
    }
}