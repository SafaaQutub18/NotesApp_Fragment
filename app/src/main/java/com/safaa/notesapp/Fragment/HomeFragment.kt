package com.safaa.notesapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.safaa.notesapp.R
import com.safaa.notesapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.startBtn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_noteFragment)
        }




        return binding.root
    }


}