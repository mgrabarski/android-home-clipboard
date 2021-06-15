package com.mg.homeclipboards.splash.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mg.homeclipboards.splash.R
import com.mg.homeclipboards.splash.ui.viewmodel.FirstInfo
import com.mg.homeclipboards.splash.ui.viewmodel.Home
import com.mg.homeclipboards.splash.ui.viewmodel.SplashScreenViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel: SplashScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        lifecycleScope.launch {
            viewModel.tryLoadUser().collect {
                when (it) {
                    is FirstInfo -> {
                    }
                    is Home -> {
                    }
                }
            }
        }
    }
}