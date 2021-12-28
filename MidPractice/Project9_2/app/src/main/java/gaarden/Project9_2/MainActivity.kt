package gaarden.Project9_2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val LINE = 1
        const val CIRCLE = 2
        const val REC = 3
        const val B = 4
        const val G = 5
        const val Red = 6
        var curShape = LINE
        var curCol = B
    }

    lateinit var myView: gaarden.Project9_2.MyGraphicView
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "간단 그림판"

        myView = findViewById(R.id.myview)

        btn = findViewById(R.id.button)

        btn.setOnClickListener{
            // 그림판 지우기
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {
        super.onCreateOptionsMenu(menu)
        menu!!.add(0, 1, 0, "선 그리기")
        menu!!.add(0, 2, 0, "원 그리기")
        menu!!.add(0, 3, 0, "사각형 그리기")

        var sMenu: SubMenu = menu.addSubMenu("색상 변경 >>")
        sMenu.add(0, 4, 0, "파랑")
        sMenu.add(0, 5, 0, "초록")
        sMenu.add(0, 6, 0, "빨강")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean {
        when (item.itemId) {
            1 -> {
                curShape = LINE // 선
                return true
            }
            2 -> {
                curShape = CIRCLE // 원
                return true
            }
            3 -> {
                curShape = REC // 사각형
                return true
            }
        }

        when (item.itemId) {
            4 -> {
                curCol = B
                return true
            }
            5 -> {
                curCol = G
                return true
            }
            6 -> {
                curCol = Red
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private class MyGraphicView(context: Context) : View(context) {
        var startX = -1f
        var startY = -1f
        var stopX = -1f
        var stopY = -1f

        override fun onTouchEvent(event: MotionEvent?) : Boolean {
            when (event!!.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x
                    startY = event.y
                }
                MotionEvent.ACTION_MOVE, MotionEvent.ACTION_UP -> {
                    stopX = event.x
                    stopY = event.y
                    this.invalidate()
                }
            }

            return true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            val paint = Paint()
            paint.isAntiAlias = true
            paint.strokeWidth = 5f
            paint.style = Paint.Style.STROKE

            when (curCol) {
                B -> {
                    paint.color = Color.BLUE
                }
                G -> {
                    paint.color = Color.GREEN
                }
                Red -> {
                    paint.color = Color.RED
                }
            }

            when (curShape) {
                LINE -> canvas.drawLine(startX, startY, stopX, stopY, paint)
                CIRCLE -> {
                    var radius = Math.sqrt(Math.pow((stopX - startX).toDouble(), 2.0) + Math.pow((stopY - startY).toDouble(), 2.0))
                    canvas.drawCircle(startX, startY, radius.toFloat(), paint)
                }
                REC -> {
                    val rect = RectF(startX, startY, stopX, stopY)
                    canvas.drawRect(rect, paint)
                }
            }

        }

    }
}
