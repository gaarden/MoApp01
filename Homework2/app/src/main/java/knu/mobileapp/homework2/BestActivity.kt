package knu.mobileapp.homework2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class BestActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.best)
        title = "세 번째 액티비티"

        val intent = intent
        val voteResult = intent.getIntArrayExtra("VoteCount")
        val imageName = intent.getStringArrayExtra("ImageName")

        val imageFileId = arrayOf(R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9)

        val tvTop = findViewById<TextView>(R.id.tvTop)
        val ivTop = findViewById<ImageView>(R.id.ivTop)

        var best = 0

        for (i in 1 until voteResult!!.size) {
            if (voteResult!![best] < voteResult[i])
                best = i
        }

        tvTop.text = imageName!![best] + ": 총 득표수" + voteResult!![best]
        ivTop.setImageResource(imageFileId[best])

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }
}