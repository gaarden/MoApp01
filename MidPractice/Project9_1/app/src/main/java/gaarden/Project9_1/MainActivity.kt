package gaarden.Project9_1

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(MyGraphicView(this))
    }

    private class MyGraphicView(context: Context) : View(context) {

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            var paint = Paint()
            paint.isAntiAlias = true
            paint.color = Color.GREEN
            canvas.drawLine(10f, 10f, 300f, 10f, paint)

            paint.color = Color.BLUE
            paint.strokeWidth = 5f
            canvas.drawLine(10f, 30f, 300f, 30f, paint)

            paint.color = Color.RED
            paint.strokeWidth = 0f

            paint.style = Paint.Style.FILL
            var rect1 = Rect(10, 50, 10 + 100, 50 + 100)
            canvas.drawRect(rect1, paint)

            paint.style = Paint.Style.STROKE
            var rect2 = Rect(130, 50, 130 + 100, 50 + 100)
            canvas.drawRect(rect2, paint)

            var rect3 = RectF(250f, 50f, 250f + 100f, 50f + 100f)
            canvas.drawRoundRect(rect3, 20f, 20f, paint)

            canvas.drawCircle(60f, 220f, 50f, paint)

            paint.strokeWidth = 5f
            var path1 = Path()
            path1.moveTo(10f, 290f)
            path1.lineTo(10f + 50f, 290f + 50f)
            path1.lineTo(10f + 100f, 290f)
            path1.lineTo(10f + 150f, 290f + 50f)
            path1.lineTo(10f + 200f, 290f)
            canvas.drawPath(path1, paint)

            paint.strokeWidth = 0f
            paint.textSize = 100f
            canvas.drawText("안드로이드", 100f, 500f, paint)

            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 5f
            var star1 = Path()
            star1.moveTo(120f, 800f)
            star1.lineTo(120f+150f, 800f)
            star1.lineTo(120f+30f, 800f+120f)
            star1.lineTo(120f+75f, 800f-60f)
            star1.lineTo(120f+120f, 800f+120f)
            star1.lineTo(120f, 800f)
            canvas.drawPath(star1, paint)

            var rect4 = Paint()
            rect4.isAntiAlias = true
            rect4.color = Color.BLUE
            rect4.strokeWidth = 50f
            canvas.drawLine(10f, 1200f, 500f, 1200f, rect4)

            var rect5 = Paint()
            rect5.isAntiAlias = true
            rect5.color = Color.GREEN
            rect5.strokeWidth = 50f
            rect5.setStrokeCap(Paint.Cap.ROUND)
            canvas.drawLine(500f, 1300f, 10f, 1300f, rect5)
            canvas.drawLine(500f, 1300f, 800f, 1300f, rect5)


            var oval = Paint()
            canvas.drawOval(10f, 1400f, 600f, 1600f, oval)
        }
    }
}