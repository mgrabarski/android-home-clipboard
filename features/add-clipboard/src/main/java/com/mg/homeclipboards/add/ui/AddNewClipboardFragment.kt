package com.mg.homeclipboards.add.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mg.homeclipboards.add.databinding.FragmentAddNewClipboardBinding
import com.mg.homeclipboards.add.ui.handlers.OnIconClickHandler
import com.mg.homeclipboards.add.ui.viewmodel.AddNewClipboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddNewClipboardFragment : Fragment() {

    private val viewModel: AddNewClipboardViewModel by viewModel()

    private var _binding: FragmentAddNewClipboardBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewClipboardBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.onIconClickHandler = OnIconClickHandler()

        binding.addBtn.setOnClickListener {
            viewModel.saveClipboard()
            requireActivity().onBackPressed()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}