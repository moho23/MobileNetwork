package com.phase.firstproject.model.ui.note

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phase.firstproject.data.local.mapper.NoteCacheMapper
import com.phase.firstproject.data.local.model.LocalNote

class NoteAdapter(val notesList: List<LocalNote>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(val itemViewNote: ItemViewNote) : RecyclerView.ViewHolder(itemViewNote)

    var listener: ItemViewNote.Listener? = null
    private val mapper = NoteCacheMapper()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(ItemViewNote(parent.context))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = notesList[position]
        holder.itemViewNote.also {
            it.note = item
            it.listener = listener
        }
    }

    override fun getItemCount(): Int = notesList.size
}