package gaarden.Project9_2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyGraphicView: View {

        var startX = -1f
        var startY = -1f
        var stopX = -1f
        var stopY = -1f

        constructor(context: Context?, attrs:AttributeSet?): super(context, attrs)

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

            when (MainActivity.curCol) {
                MainActivity.B -> {
                    paint.color = Color.BLUE
                }
                MainActivity.G -> {
                    paint.color = Color.GREEN
                }
                MainActivity.Red -> {
                    paint.color = Color.RED
                }
            }

            when (MainActivity.curShape) {
                MainActivity.LINE -> canvas.drawLine(startX, startY, stopX, stopY, paint)
                MainActivity.CIRCLE -> {
                    var radius = Math.sqrt(Math.pow((stopX - startX).toDouble(), 2.0) + Math.pow((stopY - startY).toDouble(), 2.0))
                    canvas.drawCircle(startX, startY, radius.toFloat(), paint)
                }
                MainActivity.REC -> {
                    val rect = RectF(startX, startY, stopX, stopY)
                    canvas.drawRect(rect, paint)
                }
            }
        }

    }