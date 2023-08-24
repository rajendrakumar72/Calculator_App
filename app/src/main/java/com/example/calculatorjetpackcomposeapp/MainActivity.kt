package com.example.calculatorjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculatorjetpackcomposeapp.ui.Calculator
import com.example.calculatorjetpackcomposeapp.ui.theme.CalculatorJetpackComposeAppTheme
import com.example.calculatorjetpackcomposeapp.ui.theme.MediumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorJetpackComposeAppTheme {
                val viewModel= viewModel<CalculatorViewModel>()
                val state=viewModel.state
                val btnSpace=8.dp
                
                Calculator(state = state, onAction = viewModel::onAction,
                            buttonSpacing = btnSpace,
                modifier = Modifier.fillMaxSize().background(MediumGray).padding(16.dp))
            }
        }
    }
}
