package com.example.homeworkweek5

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class TasksViewModel(val dao: TaskDao): ViewModel() {
    var newTaskName = ""

    val tasks : LiveData<List<Task>> = dao.getAll()
//        val tasksString = Transformations.map(tasks){
//            tasks->formatTasks((tasks))
//    }
//    fun formatTasks(tasks:List<Task>):String{
//        return tasks.fold(""){
//                str,item -> str + '\n' + convertToString(item)
//        }
//    }
//    fun convertToString(task:Task):String{
//        var str = '\n'+ "Number of Donut you ate : ${task.taskName}"
//        return str
//    }
    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
}