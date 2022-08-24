package com.vishnevskiypro.roomstevdza4.screens

import android.os.Binder
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vishnevskiypro.roomstevdza4.R
import com.vishnevskiypro.roomstevdza4.databinding.FragmentUpdateNoteBinding
import com.vishnevskiypro.roomstevdza4.models.Note
import com.vishnevskiypro.roomstevdza4.viewModel.NoteViewModel


class UpdateNoteFragment : Fragment() {

    private lateinit var binding: FragmentUpdateNoteBinding
    private lateinit var mViewModel: NoteViewModel
    private val args by navArgs<UpdateNoteFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentUpdateNoteBinding.inflate(layoutInflater, container, false)

        binding.noteTitle.setText(args.noteArgument.title)
        binding.description.setText(args.noteArgument.description)

        binding.save.setOnClickListener {
            updateNote()

        }

        return binding.root
    }

    private fun updateNote() {
        val title = binding.noteTitle.text.toString()
        val description = binding.description.text.toString()

        if(checkData(title, description)){
            val noteToUpdate = Note(id = args.noteArgument.id, title, description)
            mViewModel.updateNote(noteToUpdate)
            Toast.makeText(requireContext(), "Updated", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateNoteFragment_to_mainFragment)
        } else {
            Toast.makeText(requireContext(), "Fill All Fields Please", Toast.LENGTH_LONG).show()
        }


    }

    private fun checkData(title: String, description: String) : Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }
}