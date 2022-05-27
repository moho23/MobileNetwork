package com.phase.firstproject.noteDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.phase.firstproject.BaseApplication
import com.phase.firstproject.R
import com.phase.firstproject.databinding.FragmentNoteDetailBinding


class NoteDetailFragment : Fragment(R.layout.fragment_note_detail) {

    private var _binding: FragmentNoteDetailBinding? = null
    private val binding get() = _binding!!
    private val args: NoteDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleNoteDetail.text = args.note.title;
        binding.descriptionNoteDetail.text = args.note.description;

        binding.deleteNoteButton.setOnClickListener {
            BaseApplication.database.getNoteDao().deleteNote(args.note.id)
            findNavController().navigate(R.id.action_noteDetailFragment_to_noteListFragment)
        }

        binding.editNoteButton.setOnClickListener {
            findNavController().navigate(
                NoteDetailFragmentDirections.actionNoteDetailFragmentToEditNoteFragment(
                    args.note
                )
            )
        }
    }
}