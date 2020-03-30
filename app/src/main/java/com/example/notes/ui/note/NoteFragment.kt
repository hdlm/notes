package com.example.notes.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.notes.R

class NoteFragment : Fragment() {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        noteViewModel =
                ViewModelProviders.of(this).get(NoteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_note, container, false)
        val textView: TextView = root.findViewById(R.id.text_note)
        noteViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
