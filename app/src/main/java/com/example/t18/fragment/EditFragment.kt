package com.example.t18.fragment

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t18.database.Note
import com.example.t18.database.noteList
import com.example.t18.databinding.FragmentEditBinding
import java.util.*

class EditFragment : Fragment() {

    lateinit var binding: FragmentEditBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = EditFragmentArgs.fromBundle(requireArguments()).id

        edit(id)

        findNavController().navigateUp()


    }

    private fun edit(id: Int) {

        for (note in noteList) {
            if (note.id == id) {

                binding.etEditTitle.setText(note.title)
                binding.etEditText.setText(note.text)

                binding.btnEditSave.setOnClickListener {
                    note.text = binding.etEditText.text.toString()
                    note.title = binding.etEditTitle.text.toString()
                    note.time = Date().time

                }
            }
        }
    }
}
