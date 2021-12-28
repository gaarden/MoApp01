package gaarden.Practice.Project321_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var imageV: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageV = findViewById(R.id.imageV)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu!!.add(0, 1, 0, "강아지")
        menu!!.add(0, 2, 0, "고양이")
        menu!!.add(0, 3, 0, "말")
        menu!!.add(0, 4, 0, "토끼")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            1->{
                imageV.setImageResource(R.drawable.dog)
            }

            2->{
                imageV.setImageResource(R.drawable.cat)
            }

            3->{
                imageV.setImageResource(R.drawable.horse)
            }

            4->{
                imageV.setImageResource(R.drawable.rabbit)
            }
        }

        return false
    }
}