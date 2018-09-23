package forward2030.billionaire.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alert_dialog.setOnClickListener {
            showDialog()
        }

        buttonDatePicker.setOnClickListener {
            showDatePicker()
        }

        buttonTimePick.setOnClickListener {
            showTimePicker()
        }
    }

    fun showDialog()  {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("Exit Application")
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
            onBackPressed()
        })
        builder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i ->
            dialogInterface.dismiss()
        }).show()
    }

    fun showDatePicker()  {
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
            //year , month, day => pick한 날짜 변수 (month는 +1을 해주어야 한다.)
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE)).show()
    }

    fun showTimePicker()  {
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
           //hour, minute -> pick 한 시간 변수
        },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show()
    }
}
