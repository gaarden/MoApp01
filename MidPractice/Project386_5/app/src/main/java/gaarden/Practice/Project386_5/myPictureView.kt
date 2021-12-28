package gaarden.Practice.Project386_5


import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.lang.Exception

class myPictureView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    public var imagePath : String? = null
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        try {
            if (imagePath != null) {

                var cenX = this.width / 2f
                var cenY = this.height / 2f
                canvas.scale(MainActivity.sX, MainActivity.sY, cenX, cenY)
                canvas.rotate(MainActivity.angle, cenX, cenY)

                val paint = Paint()
                val array = floatArrayOf(
                    MainActivity.color,    0f,       0f,      0f,     0f,
                    0f, MainActivity.color,    0f,      0f,     0f,
                    0f,      0f, MainActivity.color,   0f,     0f,
                    0f,      0f,        0f,     1f,     0f)
                val cm = ColorMatrix(array)
                if (MainActivity.satur == 0f) cm.setSaturation(MainActivity.satur)
                paint.colorFilter = ColorMatrixColorFilter(cm)

                var picture = BitmapFactory.decodeFile(imagePath)
                var picX = (this.width - picture.width) / 2f
                var picY = (this.height - picture.height) / 2f
                canvas.drawBitmap(picture, picX, picY, paint)

                picture.recycle()
            }
        }catch (e : Exception) {
        }
    }
}
