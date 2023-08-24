package com.example.calculatorjetpackcomposeapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorjetpackcomposeapp.CalculationOperation
import com.example.calculatorjetpackcomposeapp.CalculatorAction
import com.example.calculatorjetpackcomposeapp.CalculatorState
import com.example.calculatorjetpackcomposeapp.calculatorButton
import com.example.calculatorjetpackcomposeapp.ui.theme.LightGray
import com.example.calculatorjetpackcomposeapp.ui.theme.Orange

@Composable
fun Calculator(
    state:CalculatorState,
    buttonSpacing: Dp =8.dp,
    modifier: Modifier=Modifier,
    onAction:(CalculatorAction)->Unit
){
    Box(modifier=modifier) {
        Column(modifier= Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        verticalArrangement = Arrangement.spacedBy(buttonSpacing)) {

            Text(text = state.number1 + (state.calculationOperation?.symbol ?:  "")+state.number2,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    fontWeight = FontWeight.Light,
                    fontSize = 80.sp,
                    color = Color.White,
                    maxLines = 2 )
            
            Row(modifier=  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                calculatorButton(symbols ="AC" , modifier =Modifier.background(LightGray).aspectRatio(2f).weight(2f) ,
                        onClick = {
                    onAction(CalculatorAction.Clear) }
                )
                calculatorButton(symbols ="Del" , modifier =Modifier.background(LightGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Delete) }
                )
                calculatorButton(symbols ="/" , modifier =Modifier.background(Orange).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculationOperation.Divide)) }
                )
            }

            Row(modifier=  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                calculatorButton(symbols ="7" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(7)) }
                )
                calculatorButton(symbols ="8" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(8)) }
                )
                calculatorButton(symbols ="9" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(9)) }
                )
                calculatorButton(symbols ="x" , modifier =Modifier.background(Orange).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculationOperation.Multiply)) }
                )
            }

            Row(modifier=  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                calculatorButton(symbols ="4" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(4)) }
                )
                calculatorButton(symbols ="5" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(5)) }
                )
                calculatorButton(symbols ="6" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(6)) }
                )
                calculatorButton(symbols ="-" , modifier =Modifier.background(Orange).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculationOperation.Subtract)) }
                )
            }

            Row(modifier=  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                calculatorButton(symbols ="1" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(3)) }
                )
                calculatorButton(symbols ="2" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(2)) }
                )
                calculatorButton(symbols ="3" , modifier =Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(3)) }
                )
                calculatorButton(symbols ="+" , modifier =Modifier.background(Orange).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculationOperation.Add)) }
                )
            }

            Row(modifier=  Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                calculatorButton(symbols ="0" , modifier =Modifier.background(Color.DarkGray).aspectRatio(2f).weight(2f) ,
                    onClick = {
                        onAction(CalculatorAction.Number(0)) }
                )
                calculatorButton(symbols ="." , modifier =Modifier.background(LightGray).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Decimal) }
                )
                calculatorButton(symbols ="=" , modifier =Modifier.background(Orange).aspectRatio(1f).weight(1f) ,
                    onClick = {
                        onAction(CalculatorAction.Calculation) }
                )
            }

        }
        
    }
}