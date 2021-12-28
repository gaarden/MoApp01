/**
 * 학번_이름: 저는 이 소스 코드를 다른 곳에서 복사해 오지 않고 직접 작성했습니다.
 * 만약 이 코드를 다른 곳에서 복사한 사실이 밝혀질 경우, 어떤 불이익도 감수하겠습니다.
 */

package gaarden.MyCalcApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit internal var editText: EditText

    lateinit internal var btnPlus: Button
    lateinit internal var btnMinus: Button
    lateinit internal var btnMul: Button
    lateinit internal var btnDiv: Button

    lateinit internal var btn0: Button
    lateinit internal var btn1: Button
    lateinit internal var btn2: Button
    lateinit internal var btn3: Button
    lateinit internal var btn4: Button
    lateinit internal var btn5: Button
    lateinit internal var btn6: Button
    lateinit internal var btn7: Button
    lateinit internal var btn8: Button
    lateinit internal var btn9: Button

    lateinit internal var btnEqual: Button
    lateinit internal var btnDot: Button

    lateinit internal var btnClear: Button

    lateinit var txtView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.expression)

        btnPlus = findViewById(R.id.buttonPlus)
        btnMinus = findViewById(R.id.buttonMinus)
        btnMul = findViewById(R.id.buttonMul)
        btnDiv = findViewById(R.id.buttonDiv)

        btn0 = findViewById(R.id.button0)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)
        btn5 = findViewById(R.id.button5)
        btn6 = findViewById(R.id.button6)
        btn7 = findViewById(R.id.button7)
        btn8 = findViewById(R.id.button8)
        btn9 = findViewById(R.id.button9)

        btnEqual = findViewById(R.id.buttonSame)
        btnDot = findViewById(R.id.buttonDot)

        btnClear = findViewById(R.id.buttonClear)

        txtView = findViewById(R.id.result)

        txtView.setText("아래 버튼을 눌러주세요.")



        btn0.setOnClickListener{
            editText.text.append("0")
        }
        btn1.setOnClickListener{
            editText.text.append("1")
        }
        btn2.setOnClickListener{
            editText.text.append("2")
        }
        btn3.setOnClickListener{
            editText.text.append("3")
        }
        btn4.setOnClickListener{
            editText.text.append("4")
        }
        btn5.setOnClickListener{
            editText.text.append("5")
        }
        btn6.setOnClickListener{
            editText.text.append("6")
        }
        btn7.setOnClickListener{
            editText.text.append("7")
        }
        btn8.setOnClickListener{
            editText.text.append("8")
        }
        btn9.setOnClickListener{
            editText.text.append("9")
        }
        btnPlus.setOnClickListener{
            editText.text.append("+")
        }
        btnMinus.setOnClickListener{
            editText.text.append("-")
        }
        btnMul.setOnClickListener{
            editText.text.append("*")
        }
        btnDiv.setOnClickListener{
            editText.text.append("/")
        }
        btnDot.setOnClickListener{
            editText.text.append(".")
        }
        btnClear.setOnClickListener{
            editText.setText("0")
        }

        btnEqual.setOnClickListener{
            var exp = StringTokenizer(editText.text.toString(), "+-*/")
            var left: Double = exp.nextToken().toDouble()
            var right: Double = exp.nextToken().toDouble()
            var res: Double = 0.0

            if (editText.text.contains("+")) {
                res = left + right
            }
            else if (editText.text.contains("-")){
                res = left - right
            }
            else if (editText.text.contains("*")){
                res = left * right
            }
            else if (editText.text.contains("/")){
                res = left / right
            }

            txtView.setText(editText.text.append(" = " + res))
            editText.setText("0")
        }


    }


}