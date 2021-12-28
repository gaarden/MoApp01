package knu.mobileapp.practice.Project429

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "그리드뷰 영화 포스터"

        var gv: GridView
        var gAdapter = MyGridAdapter(this)
        gv = findViewById(R.id.gridView1)
        gv.adapter = gAdapter
    }

    inner class MyGridAdapter(var context: Context): BaseAdapter(){

        var postID = arrayOf(
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10
        )

        var posterTitle = arrayOf("써니", "완득이", "괴물", "라디오스타", "비열한거리",
            "왕의남자", "아일랜드", "웰컴투동막골", "헬보이", "빽투더퓨처")

        override fun getCount(): Int {
            return postID.size
        }

        override fun getItem(p0: Int): Any {
            return 0
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var imageview = ImageView(context)
            imageview.layoutParams = ViewGroup.LayoutParams(200, 300)
            imageview.scaleType = ImageView.ScaleType.FIT_CENTER
            imageview.setPadding(5, 5, 5, 5)

            imageview.setImageResource(postID[p0])

            imageview.setOnClickListener{
                var dialogView = View.inflate(this@MainActivity, R.layout.dialog, null)
                var dlg = AlertDialog.Builder(this@MainActivity)
                var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
                ivPoster.setImageResource(postID[p0])
                dlg.setTitle(posterTitle[p0])
                dlg.setIcon(R.drawable.ic_launcher_background)
                dlg.setView(dialogView)
                dlg.setNegativeButton("닫기", null)
                dlg.show()
            }

            return imageview
        }
    }
}