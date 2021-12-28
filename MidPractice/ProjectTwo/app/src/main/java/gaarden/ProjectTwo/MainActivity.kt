package gaarden.ProjectTwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var num1: EditText
    lateinit var num2: EditText

    lateinit var plus: Button
    lateinit var minus: Button
    lateinit var mul: Button
    lateinit var div: Button
    lateinit var rem: Button

    lateinit var result: TextView

    lateinit var enternum1: String
    lateinit var enternum2: String

    var showresult: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num1 = findViewById<EditText>(R.id.Editnum1)
        num2 = findViewById<EditText>(R.id.Editnum2)

        plus = findViewById<Button>(R.id.Btnplus)
        minus = findViewById<Button>(R.id.Btnminus)
        mul = findViewById<Button>(R.id.Btnmul)
        div = findViewById<Button>(R.id.Btndiv)
        rem = findViewById<Button>(R.id.Btnrem)

        result = findViewById<TextView>(R.id.Textresult)

        plus.setOnClickListener{
            enternum1 = num1.text.toString()
            enternum2 = num2.text.toString()
            showresult = java.lang.Double.parseDouble(enternum1)+java.lang.Double.parseDouble(enternum2)
            result.text = "계산 결과: "+showresult.toString()
        }

        minus.setOnClickListener{
            enternum1 = num1.text.toString()
            enternum2 = num2.text.toString()
            showresult = java.lang.Double.parseDouble(enternum1)-java.lang.Double.parseDouble(enternum2)
            result.text = "계산 결과: "+showresult.toString()
        }

        mul.setOnClickListener{
            enternum1 = num1.text.toString()
            enternum2 = num2.text.toString()
            showresult = java.lang.Double.parseDouble(enternum1)*java.lang.Double.parseDouble(enternum2)
            result.text = "계산 결과: "+showresult.toString()
        }

        div.setOnClickListener{
            enternum1 = num1.text.toString()
            enternum2 = num2.text.toString()
            showresult = java.lang.Double.parseDouble(enternum1)/java.lang.Double.parseDouble(enternum2)
            result.text = "계산 결과: "+showresult.toString()
        }

        rem.setOnClickListener{
            enternum1 = num1.text.toString()
            enternum2 = num2.text.toString()
            showresult = java.lang.Double.parseDouble(enternum1)%java.lang.Double.parseDouble(enternum2)
            result.text = "계산 결과: "+showresult.toString()
        }

    }

}