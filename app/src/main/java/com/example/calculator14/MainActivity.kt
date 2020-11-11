package com.example.calculator14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.TextureView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
     lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun numberClick(view: View) {

        if (view is TextView) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if (result == "0") {
                result = ""

            }
            resultTextView.text = result + number
        }


    }


    fun clearClick(view: View) {
        resultTextView.text = ""
    }

    fun delClick(view: View) {
        var del = resultTextView.text.toString()
        if (!TextUtils.isEmpty(del)) {
            resultTextView.text = del.substring(0, del.length-1)
        }
    }

    fun operationClick(view: View) {

        if (view is  TextView) {

            if (!TextUtils.isEmpty(resultTextView.text)) {
                operand = resultTextView.text.toString().toDouble()
            }
            resultTextView.text =""

            operation = view.text.toString()
        }
    }

    fun equalsClick(view: View) {

        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if (!TextUtils.isEmpty(secOperandText)) {
            secOperand = secOperandText.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
        }
    }


}