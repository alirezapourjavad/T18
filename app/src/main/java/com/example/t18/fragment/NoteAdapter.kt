package com.example.t18.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.t18.database.Note
import com.example.t18.database.formatDate
import com.example.t18.databinding.HomeRecycleBinding
import java.util.*

class NoteAdapter(
    private val noteList: List<Note>,
    private val editClick: (note: Note) -> Unit
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {


    class NoteViewHolder(val binding: HomeRecycleBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HomeRecycleBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = noteList[position]
        holder.binding.tvText.text = item.text
        holder.binding.tvTitle.text = item.title
        holder.binding.tvTime.text = item.time.formatDate()

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, item.title, Toast.LENGTH_SHORT).show()
        }
        holder.binding.icEdit.setOnClickListener { editClick.run { invoke(item) } }

    }

    override fun getItemCount(): Int {
        return noteList.size
    }


}