package com.example.t18.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t18.databinding.FragmentAddBinding
import com.example.t18.database.Note
import com.example.t18.database.noteList
import java.util.*


class AddFragment : Fragment() {

    lateinit var binding : FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val text = binding.etText.text.toString()
            val title = binding.etTitle.text.toString()
            val time = Date().time
            val note = Note(title, text, time)
            noteList.add(note)

            findNavController().navigateUp()
        }
    }

}