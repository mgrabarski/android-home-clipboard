package com.mg.homeclipboard.home.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mg.homeclipboard.home.R
import com.mg.homeclipboard.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        binding.addNewClipboardFab.setOnClickListener {
            navigateToAddNewClipboard(it)
        }

        return binding.root
    }

    private fun navigateToAddNewClipboard(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToAddNewClipboardFragment()
        view.findNavController().navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.setting -> {
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}