package com.example.calculatorjetpackcomposeapp

sealed class CalculationOperation(val symbol:String){
    object Add:CalculationOperation("+")
    object Subtract:CalculationOperation("-")
    object Multiply:CalculationOperation("x")
    object Divide:CalculationOperation("/")

}
