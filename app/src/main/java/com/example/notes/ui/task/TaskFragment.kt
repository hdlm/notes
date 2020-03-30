package com.example.notes.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.notes.R

class TaskFragment : Fragment() {

    private lateinit var taskViewModel: TaskViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        taskViewModel =
                ViewModelProviders.of(this).get(TaskViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_task, container, false)
        val textView: TextView = root.findViewById(R.id.text_task)
        taskViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
