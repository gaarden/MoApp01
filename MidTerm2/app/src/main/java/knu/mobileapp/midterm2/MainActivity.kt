package knu.mobileapp.midterm2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var button1: Button
    lateinit var button2: Button

    lateinit var graphicLayout: LinearLayout

    companion object{
        const val CIRCLE = 1
        const val TRIANGLE = 2
        var curShape = CIRCLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        graphicLayout = findViewById(R.id.graphicLayout)
        var graphicView = MyGraphicView(this)
        graphicLayout.addView(graphicView)


        button1.setOnClickListener{
            curShape = CIRCLE
        }

        button2.setOnClickListener{
            curShape = TRIANGLE
        }

    }

    class MyGraphicView(context: Context): View(context){

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE
            paint.color = Color.RED

            when(curShape){
                1-> {
                    canvas?.drawCircle(0f, height.toFloat(), width / 2f, paint)
                }
            }

        }
    }
}