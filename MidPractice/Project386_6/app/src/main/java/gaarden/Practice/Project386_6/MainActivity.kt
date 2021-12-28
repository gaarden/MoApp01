package gaarden.Practice.Project386_6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val LINE = 1
        const val CIRCLE = 2
        const val RECT = 3
        var curShape = LINE

        const val COLORR = 4
        const val COLORG = 5
        const val COLORB = 6
        var color = COLORR

        var myShape: ArrayList<MyShape> = ArrayList()
    }

    lateinit var mgv: MyGraphicView

    class MyShape{
        var shapeType: Int = 0
        var startX: Float = -1f
        var startY: Float = -1f
        var stopX: Float = -1f
        var stopY: Float = -1f
        var colorType: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mgv = MyGraphicView(this)
        setContentView(mgv)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        menu!!.add(0, 1, 0, "선 그리기")
        menu!!.add(0, 2, 0, "원 그리기")
        menu!!.add(0, 3, 0, "사각형 그리기")

        var sMenu: SubMenu = menu.addSubMenu("색상 변경 >>")
        sMenu.add(0, 4, 0, "빨강")
        sMenu.add(0, 5, 0, "초록")
        sMenu.add(0, 6, 0, "파랑")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{
                curShape = LINE
                return true
            }

            2->{
                curShape = CIRCLE
                return true
            }

            3->{
                curShape = RECT
                return true
            }

            4->{
                color = COLORR
                return true
            }

            5->{
                color = COLORG
                return true
            }

            6->{
                color = COLORB
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    class MyGraphicView(context: Context): View(context){
        var startX = -1f
        var startY = -1f
        var stopX = -1f
        var stopY = -1f

        override fun onTouchEvent(event: MotionEvent?): Boolean {
            when(event!!.action){
                MotionEvent.ACTION_DOWN->{
                    startX = event.x
                    startY = event.y
                }

                MotionEvent.ACTION_MOVE->{
                    stopX = event.x
                    stopY = event.y

                    this.invalidate()
                }

                MotionEvent.ACTION_UP->{
                    val shape = MyShape()
                    shape.shapeType = curShape
                    shape.startX = startX
                    shape.startY = startY
                    shape.stopX = stopX
                    shape.stopY = stopY
                    shape.colorType = color
                    myShape.add(shape)

                    this.invalidate()
                }
            }

            return true
        }

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            val paint = Paint()
            paint.style = Paint.Style.STROKE
            paint.isAntiAlias = true

            canvas.drawColor(Color.WHITE)

            for (i in myShape.indices) {
                val drawShape = myShape[i]

                when(drawShape.colorType){
                    COLORR->paint.color = Color.RED
                    COLORG->paint.color = Color.GREEN
                    COLORB->paint.color = Color.BLUE
                }

                when(drawShape.shapeType){
                    LINE->{
                        canvas.drawLine(drawShape.startX, drawShape.startY, drawShape.stopX, drawShape.stopY, paint)
                    }

                    CIRCLE->{
                        var radius = Math.sqrt(Math.pow((drawShape.stopX-drawShape.startX).toDouble(), 2.0) +
                        Math.pow((drawShape.stopY-drawShape.startY).toDouble(), 2.0))
                        canvas.drawCircle(drawShape.startX, drawShape.startY, radius.toFloat(), paint)
                    }

                    RECT->{
                        val rect = RectF(drawShape.startX, drawShape.startY, drawShape.stopX, drawShape.stopY)
                        canvas.drawRect(rect, paint)
                    }
                }
            }
        }

    }
}