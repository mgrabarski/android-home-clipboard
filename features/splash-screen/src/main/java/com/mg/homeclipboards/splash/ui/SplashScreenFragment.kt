package com.mg.homeclipboards.splash.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mg.homeclipboards.splash.databinding.FragmentSplashBinding
import com.mg.homeclipboards.splash.ui.SplashScreenFragmentDirections.actionSplashScreenFragmentToFirstGuideActivity
import com.mg.homeclipboards.splash.ui.SplashScreenFragmentDirections.actionSplashScreenFragmentToHomeActivity
import com.mg.homeclipboards.splash.ui.viewmodel.FirstInfo
import com.mg.homeclipboards.splash.ui.viewmodel.Home
import com.mg.homeclipboards.splash.ui.viewmodel.SplashScreenViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding: FragmentSplashBinding
        get() = _binding!!

    private val viewModel: SplashScreenViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
            .apply { lifecycleOwner = this@SplashScreenFragment }

        lifecycleScope.launch {
            delay(1000)
            viewModel.tryLoadUser().collect {
                val action = when (it) {
                    is FirstInfo -> {
                        actionSplashScreenFragmentToFirstGuideActivity()
                    }
                    is Home -> {
                        actionSplashScreenFragmentToHomeActivity()
                    }
                }
                findNavController().navigate(action)
                requireActivity().finish()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}