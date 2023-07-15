package com.pseudoankit.contactscmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.pseudoankit.contactscmp.App
import com.pseudoankit.contactscmp.core.presentation.ImagePickerFactory
import com.pseudoankit.contactscmp.di.AppModule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                App(
                    darkTheme = isSystemInDarkTheme(),
                    dynamicColor = true,
                    appModule = AppModule(LocalContext.current.applicationContext),
                    imagePicker = ImagePickerFactory().createPicker()
                )
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
