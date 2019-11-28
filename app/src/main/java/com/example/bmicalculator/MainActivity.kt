package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnCalc).setOnClickListener{
            calc()
        }
        findViewById<Button>(R.id.btnReset).setOnClickListener{
            reset()
        }
    }

    public fun calc(){
        try {
            val height = editHeight.text.toString()
            val weight = editWeight.text.toString()
            val bmi: Double = weight.toDouble() / (Math.pow(height.toDouble(), 2.00))

            if (bmi <= 18.5) {
                imageView.setImageResource(R.drawable.under)
                result.text = "%.2f".format(bmi) + " is Underweight"
            } else if (bmi > 25) {
                imageView.setImageResource(R.drawable.over)
                result.text = "%.2f".format(bmi) + " is Overweight"
            } else {
                imageView.setImageResource(R.drawable.normal)
                result.text = "%.2f".format(bmi) + " is Normal"
            }
        }catch (ex:Exception){
            val toast = Toast.makeText(applicationContext, "Please Enter something", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
    }

    public fun reset(){
        editHeight.setText("")
        editWeight.setText("")
        result.setText("")
        imageView.setImageResource(R.drawable.empty)
    }
}
