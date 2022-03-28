package com.example.homeworkweek5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.homeworkweek5.databinding.FragmentTasksBinding

//import com.example.viewmodelexample.BR.myViewModel //BR = binding root


/**
 * A simple [Fragment] subclass.
 * Use the [TasksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TasksFragment : Fragment() {
    private var _binding : FragmentTasksBinding? = null
    private val binding get() = _binding
    //lateinit var binding: FragmentTasksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTasksBinding.inflate(inflater,container,false)
        val view = binding!!.root
        //     _binding = LayoutInflater.container: ViewGroup? .inflate(inflater, R.layout.fragment_tasks, container, false)
        //binding.setLifecycleOwner(this)
        val application= requireNotNull(this.activity).application
        val dao = TaskDatabase.getInstance(application).taskDao
        val viewModelFactory = TasksViewModelFactory(dao)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(TasksViewModel::class.java)
        binding!!.viewModel = viewModel
        binding!!.lifecycleOwner=viewLifecycleOwner

        val adapter = TaskItemAdapter()
        binding!!.tasksList.adapter=adapter
        viewModel.tasks.observe(viewLifecycleOwner, Observer { if(it != null) it.let{
            adapter.data=it
        } })

        return view
    }

}