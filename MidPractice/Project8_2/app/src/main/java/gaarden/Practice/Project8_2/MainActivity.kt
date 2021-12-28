package gaarden.Practice.Project8_2

import android.content.Context
import java.io.File

import android.os.Environment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnPrev : Button
    lateinit var btnNext : Button
    lateinit var myPicture : myPictureView
    lateinit var tvNumber : TextView
    var curNum : Int = 0
    var imageFiles : Array<File>? = null
    var imageFname : String? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 이미지 뷰어 (변경)"
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), Context.MODE_PRIVATE)

        btnPrev = findViewById<View>(R.id.btnPrev) as Button
        btnNext = findViewById<View>(R.id.btnNext) as Button
        tvNumber = findViewById<View>(R.id.tvNumber) as TextView
        myPicture = findViewById<View>(R.id.myPictureView1) as myPictureView

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

}