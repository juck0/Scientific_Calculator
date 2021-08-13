package com.example.test

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.scientificcalculator.Operation
import com.example.scientificcalculator.R

class MainActivity<view> : AppCompatActivity() {
    lateinit var plusButton: Buttom
    lateinit var minusButton: Buttom
    lateinit var multiplicationButton: Buttom
    lateinit var divButton: Buttom
    var resultButton: Buttom = null
    lateinit var textNumber: TextView
    lateinit var clearButton: Buttom
    var lastNumber:Double =0.0
    var CurrentOperation: Operation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        addCallback()

    }

    private fun addCallback(){
        clearButton.setOnClickLisX  tener {
            clearInput()
        }
        plusButton.setOnClickListener {
            prepareOperation(Operation.Plus)
        }
        minusButton.setOnClickListener {
            prepareOperation(Operation.Minus)
        }
        multiplicationButton.setOnClickListener {
            prepareOperation(Operation.Mul)
        }
        divButton.setOnClickListener {
            prepareOperation(Operation.Div)
        }
        resultButton.setOnClickListener {
            var result = doCurrentOperation()
            textNumber.text = result.toString()
        }
    }


    private fun doCurrentOperation():Double{
        val secondNumber = textNumber.text.toString().toDouble()
        return when(CurrentOperation){
            Operation.Plus -> lastNumber + secondNumber
            Operation.Minus -> lastNumber - secondNumber
            Operation.Mul -> lastNumber * secondNumber
            Operation.Div -> lastNumber / secondNumber
            else -> 0.0

        }
    }

    private fun initView(){
        plusButton = findViewById(R.id.plusButton)
        minusButton = findViewById(R.id.minusButton)
        multiplicationButton = findViewById(R.id.multiplicationButton)
        divButton = findViewById(R.id.divButton)
        resultButton = findViewById(R.id.resultButton)
        textNumber = findViewById(R.id.textNumber)
        clearButton = findViewById(R.id.clearButton)
    }

    fun clearInput(){
        textNumber.text=""
    }
    fun prepareOperation(operation: Operation){
        lastNumber = textNumber.text.toString().toDouble()
        clearInput()
        CurrentOperation = operation
    }

    fun onClickNumber(v:view){
        val newDigit = ( v as Button).test.toString()
        val oldDigits = textNumber.test.toString()
        val newTextNumber = oldDigits + newDigit
        textNumber.test = newTextNumber
    }

}