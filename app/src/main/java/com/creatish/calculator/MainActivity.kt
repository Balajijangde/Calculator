package com.creatish.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var operator : String = ""
    private var firstOperand : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun allClear(view:View){
        showNumber.text = ""
        showNumber2.text = ""
        operator = ""
    }
    fun switchSign(view:View){
        if(showNumber.text != "" ){
            showNumber.text = (showNumber.text.toString().toDouble() * -1).toString()
        }

    }

    fun putDot(view:View){
        if(!("." in showNumber.text.toString())){
            showNumber.text = showNumber.text.toString() + "."
        }
    }

    fun btnNumClick(view:View){
        val pressed = view as Button
        showNumber.text = showNumber.text.toString() + pressed.text.toString()
    }

    fun btnOpClick(view:View){
        val pressed = view as Button
        if(showNumber.text != ""){
            when(pressed.id){
                R.id.btnDivide->{
                    operator = "/"
                }
                R.id.btnMultiply->{
                    operator = "*"
                }
                R.id.btnSubtract->{
                    operator = "-"
                }
                R.id.btnAdd->{
                    operator = "+"
                }
            }
        }

        showNumber2.text = showNumber.text
        firstOperand = showNumber.text.toString().toDouble()
        showNumber.text = ""
    }

    fun btnEqual(view: View){
        if(operator != "" && firstOperand != 0.0 && showNumber.text != ""){
            showNumber2.text = showNumber.text.toString()
            when(operator){
                "+"->{
                    showNumber.text = (firstOperand + showNumber.text.toString().toDouble()).toString()
                }
                "-"->{
                    showNumber.text = (firstOperand - showNumber.text.toString().toDouble()).toString()
                }
                "*"->{
                    showNumber.text = (firstOperand * showNumber.text.toString().toDouble()).toString()
                }
                "/"->{
                    showNumber.text = (firstOperand / showNumber.text.toString().toDouble()).toString()
                }
            }
            operator = ""
            firstOperand = showNumber.text.toString().toDouble()
        }
    }

    fun btnPercent(view:View){
        if(showNumber.text != ""){
            showNumber2.text = showNumber.text
            showNumber.text = (showNumber.text.toString().toDouble() / 100).toString()
        }
    }
}