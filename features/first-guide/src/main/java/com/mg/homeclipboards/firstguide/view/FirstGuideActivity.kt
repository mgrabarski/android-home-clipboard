package com.mg.homeclipboards.firstguide.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.mg.homeclipboard.home.ui.HomeActivity
import com.mg.homeclipboards.domain.interactor.user.CreateAndLoginNewUser
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import com.mg.homeclipboards.firstguide.databinding.ActivityFirstGuideBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class FirstGuideActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstGuideBinding
    private val createNewUser: CreateAndLoginNewUser by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.finish.setOnClickListener {
            createUserAndGoToHome()
        }
    }

    private fun createUserAndGoToHome() {
        lifecycleScope.launch {
            createNewUser.create().collect {
                when (it) {
                    is Success -> {
                        finish()
                        startActivity(Intent(this@FirstGuideActivity, HomeActivity::class.java))
                    }
                    is Failure -> {

                    }
                }
            }
        }
    }
}