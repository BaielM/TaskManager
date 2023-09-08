package com.example.taskmanager.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.App
import com.example.taskmanager.databinding.FragmentTaskBinding
import com.example.taskmanager.model.Task
import java.util.Date

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            App.db.taskDao().insert(
                Task(
                    title = binding.etTitle.text.toString(),
                    description = binding.etDesc.text.toString()
                )
            )
            findNavController().navigateUp()
        }
    }
    companion object{
        const val REQUEST_RESULT="request.result"
        const val TASK_KEY = "task.key"
    }
}