package com.example.calculatorjetpackcomposeapp

data class CalculatorState(
    val number1:String="",
    val number2: String="",
    val calculationOperation: CalculationOperation?=null
)
