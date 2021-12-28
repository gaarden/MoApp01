/**
 * 2020110975_문정원: 저는 이 소스 코드를 다른 곳에서 복사해 오지 않고 직접 작성했습니다.
 * 만약 이 코드를 다른 곳에서 복사한 사실이 밝혀질 경우, 어떤 불이익도 감수하겠습니다.
 */

package knu.mobileapp.homework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title="문정원(과제2)"

        var voteCount = IntArray(9)

        for (i in 0..8)
            voteCount[i] = 0

        var image = arrayOfNulls<ImageView>(9)
        var imageId = arrayOf(R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9)
        var imgName = arrayOf("독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
            "이레느깡 단 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들", "해변에서")

        for (i in imageId.indices){
            image[i] = findViewById(imageId[i])
            image[i]!!.setOnClickListener{
                voteCount[i]++
                Toast.makeText(applicationContext, imgName[i]+": 총 "+voteCount[i]+" 표", Toast.LENGTH_SHORT).show()
            }
        }

        var btnFinish = findViewById<Button>(R.id.btnResult)
        btnFinish.setOnClickListener{
            var intent = Intent(applicationContext, ResultActivity::class.java)
            intent.putExtra("VoteCount", voteCount)
            intent.putExtra("ImageName", imgName)
            startActivity(intent)
        }
    }
}