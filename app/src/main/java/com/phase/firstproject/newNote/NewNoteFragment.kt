package com.phase.firstproject.newNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.phase.firstproject.BaseApplication
import com.phase.firstproject.R
import com.phase.firstproject.data.local.mapper.NoteCacheMapper
import com.phase.firstproject.databinding.FragmentNewNoteBinding
import com.phase.firstproject.model.Note


class NewNoteFragment : Fragment(R.layout.fragment_new_note) {

    private var _binding: FragmentNewNoteBinding? = null
    private val binding get() = _binding!!
    private val mapper = NoteCacheMapper()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitNote.setOnClickListener {
            val title: String = binding.titleNote.text.toString()
            val description: String = binding.descriptionNote.text.toString()
            val note = Note(title, description)
            BaseApplication.database.getNoteDao().insert(mapper.mapFrom(note))
            findNavController().navigate(R.id.action_newNoteFragment_to_noteListFragment)
        }
    }
}