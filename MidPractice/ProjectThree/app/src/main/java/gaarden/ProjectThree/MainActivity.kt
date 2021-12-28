package gaarden.ProjectThree

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var chrono: Chronometer
    lateinit var rdoCal: RadioButton
    lateinit var rdoTime: RadioButton
    lateinit var dateView: DatePicker
    lateinit var tPicker: TimePicker
    lateinit var tvYear: TextView
    lateinit var tvMonth: TextView
    lateinit var tvDay: TextView
    lateinit var tvHour: TextView
    lateinit var tvMinute: TextView

    var selectYear: Int = 0
    var selectMonth: Int = 0
    var selectDay: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="시간 예약"

        chrono = findViewById(R.id.chronometer1)

        rdoCal = findViewById(R.id.rdoCal)
        rdoTime = findViewById(R.id.rdoTime)

        tPicker = findViewById(R.id.timePicker1)
        dateView = findViewById(R.id.dateView1)

        tvYear = findViewById(R.id.tvYear)
        tvMonth = findViewById(R.id.tvMonth)
        tvDay = findViewById(R.id.tvDay)
        tvHour = findViewById(R.id.tvHour)
        tvMinute = findViewById(R.id.tvMinute)

        rdoCal.visibility = View.INVISIBLE
        rdoTime.visibility = View.INVISIBLE

        tPicker.visibility = View.INVISIBLE
        dateView.visibility = View.INVISIBLE

        chrono.setOnClickListener{
            rdoCal.visibility = View.VISIBLE
            rdoTime.visibility = View.VISIBLE

            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
        }

        rdoCal.setOnClickListener {
            tPicker.visibility = View.INVISIBLE
            dateView.visibility = View.VISIBLE
        }

        rdoTime.setOnClickListener{
            tPicker.visibility = View.VISIBLE
            dateView.visibility = View.INVISIBLE
        }

        tvYear.setOnClickListener{
            chrono.stop()
            chrono.setTextColor(Color.BLUE)

            rdoCal.visibility = View.INVISIBLE
            rdoTime.visibility = View.INVISIBLE

            tPicker.visibility = View.INVISIBLE
            dateView.visibility = View.INVISIBLE

            tvYear.text = Integer.toString(selectYear)
            tvMonth.text = Integer.toString(selectMonth)
            tvDay.text = Integer.toString(selectDay)

            tvHour.text = Integer.toString(tPicker.currentHour)
            tvMinute.text = Integer.toString(tPicker.currentMinute)
        }

        dateView.setOnDateChangedListener{view, year, month, dayOfMonth->
            selectYear = year
            selectMonth = month+1
            selectDay = dayOfMonth
        }
    }
}