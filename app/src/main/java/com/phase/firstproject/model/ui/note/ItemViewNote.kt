package com.phase.firstproject.model.ui.note

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.phase.firstproject.data.local.model.LocalNote
import com.phase.firstproject.databinding.ItemViewNoteBinding

class ItemViewNote @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var _binding: ItemViewNoteBinding? = null
    val binding get() = _binding!!

    var note: LocalNote? = null
        set(value) {
            field = value
            note?.let { note ->
                binding.noteTitle.text = note.title
                binding.noteDescription.text = note.description
            }
        }
    var listener: Listener? = null

    init {
        _binding = ItemViewNoteBinding.inflate(LayoutInflater.from(context), this, true)
        binding.root.setOnClickListener {
            note?.let { note ->
                listener?.onItemClicked(note)
            }
        }
    }

    interface Listener {
        fun onItemClicked(note: LocalNote)
    }
}