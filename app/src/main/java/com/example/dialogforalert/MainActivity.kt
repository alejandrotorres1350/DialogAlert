package com.example.dialogforalert

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var alertBtn: Button
    lateinit var dateBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alertBtn = findViewById(R.id.alertbtn)
        dateBtn = findViewById(R.id.datebtn)

        alertBtn.setOnClickListener {
            onClickShowAlert(alertBtn)
        }

        dateBtn.setOnClickListener {
            showDatePicker(dateBtn)
        }
    }

    fun onClickShowAlert(view: View){
        var myBuilder : AlertDialog.Builder = AlertDialog.Builder(this)
        myBuilder.setTitle("Alert")
        myBuilder.setMessage("Click OK to continue, or Cancel to stop:")

        myBuilder.setPositiveButton("OK"){dialog, which ->
            Toast.makeText(applicationContext,"Pressed Ok",Toast.LENGTH_SHORT).show()
        }

        myBuilder.setNegativeButton("Cancel"){dialog, which ->
            Toast.makeText(applicationContext,"Pressed Cancel",Toast.LENGTH_SHORT).show()
        }

        myBuilder.show()
    }

    fun showDatePicker(view: View){
        val newFragment: DialogFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager,"datePicker")
    }

    fun processDAtePickerResult(year: Int, month:Int, day: Int){
        var monthString: String = (month+1).toString()
        var dayString: String = (day).toString()
        var yearString: String = (year).toString()
        var dateMessage: String = (dayString + "/" + monthString + "/" + yearString)
        Toast.makeText(applicationContext, dateMessage,Toast.LENGTH_SHORT).show()
    }
}
