package com.vishnevskiypro.roomstevdza4.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.roomstevdza4.R
import com.vishnevskiypro.roomstevdza4.databinding.FragmentMainBinding
import com.vishnevskiypro.roomstevdza4.viewModel.NoteViewModel


class MainFragment : Fragment() {

    private lateinit var mViewModel: NoteViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: AdapterNote
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        recycler = binding.recyclerView
        adapter = AdapterNote()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())

        mViewModel.listOfNotes.observe(viewLifecycleOwner, Observer { list ->
            adapter.setList(list)
        })


        binding.addNote.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}