package com.example.composeintagramapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeintagramapp.login.ui.LoginScreen
import com.example.composeintagramapp.login.ui.LoginViewModel
import com.example.composeintagramapp.ui.theme.ComposeIntagramAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntagramAppTheme {
                Surface (modifier = Modifier.fillMaxSize()){
                    LoginScreen(LoginViewModel())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeIntagramAppTheme {
        Surface (modifier = Modifier.fillMaxSize()){
            //LoginScreen()
        }
    }
}

