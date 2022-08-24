package com.vishnevskiypro.roomstevdza4.screens

import android.icu.text.CaseMap
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.vishnevskiypro.roomstevdza4.R
import com.vishnevskiypro.roomstevdza4.databinding.FragmentAddBinding
import com.vishnevskiypro.roomstevdza4.models.Note
import com.vishnevskiypro.roomstevdza4.viewModel.NoteViewModel


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mViewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentAddBinding.inflate(layoutInflater, container, false)

        binding.save.setOnClickListener {
            addNoteToDatabase()
        }
        return binding.root
    }

    private fun addNoteToDatabase() {
        val title = binding.noteTitle.text.toString()
        val description = binding.description.text.toString()

        if (checkData(title, description)){
            val noteToAdd = Note(id = 0, title, description)
            mViewModel.addNote(noteToAdd)
            Toast.makeText(requireContext(), "Added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_mainFragment)
        } else {
            Toast.makeText(requireContext(), "Fill all filds", Toast.LENGTH_LONG).show()
        }


    }

    private fun checkData(title: String, description: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }
}