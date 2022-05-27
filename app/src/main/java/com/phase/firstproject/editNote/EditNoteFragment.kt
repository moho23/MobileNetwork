package com.phase.firstproject.editNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.phase.firstproject.BaseApplication
import com.phase.firstproject.R
import com.phase.firstproject.data.local.mapper.NoteCacheMapper
import com.phase.firstproject.databinding.FragmentEditNoteBinding

class EditNoteFragment : Fragment(R.layout.fragment_edit_note) {

    private var _binding: FragmentEditNoteBinding? = null
    private val binding get() = _binding!!
    private val mapper = NoteCacheMapper()
    private val args: EditNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTitleNote.setText(args.note.title)
        binding.editDescriptionNote.setText(args.note.description)

        binding.submitEditNote.setOnClickListener {
            val title: String = binding.editTitleNote.text.toString()
            val description: String = binding.editDescriptionNote.text.toString()
            BaseApplication.database.getNoteDao().updateNote(args.note.id, title, description)
            findNavController().navigate(R.id.action_editNoteFragment_to_noteListFragment)
        }
    }
}