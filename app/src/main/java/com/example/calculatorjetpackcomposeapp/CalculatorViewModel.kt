package com.example.calculatorjetpackcomposeapp

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CalculatorViewModel:ViewModel() {

    var state by mutableStateOf(CalculatorState())
        private set


    fun onAction(action: CalculatorAction){
        when(action){
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state= CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculation -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when{
            state.number2.isNotBlank()->state=state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.calculationOperation!=null->state=state.copy(
                calculationOperation = null
            )

            state.number1.isNotBlank()->state=state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val number1=state.number1.toDoubleOrNull()
        val number2=state.number2.toDoubleOrNull()

        if (number1!=null && number2!=null){
            val result=  when(state.calculationOperation){
                is CalculationOperation.Add -> number1+number2
                is CalculationOperation.Subtract -> number1-number2
                is CalculationOperation.Multiply -> number1*number2
                is CalculationOperation.Divide -> number1/number2
                null->return
            }

            state=state.copy(
                number1=result.toString().take(15),
                number2="",
                calculationOperation = null
            )
        }
    }

    private fun enterOperation(operation: CalculationOperation) {
        if(state.number1.isNotBlank()){
            state= state.copy(calculationOperation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.calculationOperation==null && !state.number1.contains(".")
            &&state.number1.isNotBlank()){

            state.copy(number1 = state.number1 + ".")
            return
        }

        if (!state.number2.contains(".")
            &&state.number2.isNotBlank()){

            state.copy(number1 = state.number2 + ".")

        }
    }

    private fun enterNumber(number: Int) {
        if (state.calculationOperation==null){
            if (state.number1.length>= MAX_NUM_LENGTH){
                return
            }

            state=state.copy(number1 = state.number1+number)
            return
        }
        if (state.number2.length>= MAX_NUM_LENGTH){
            return
        }
        state=state.copy(number2 = state.number2+number)
    }

    companion object{
        private const val MAX_NUM_LENGTH=8
    }
}