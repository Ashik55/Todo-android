package com.sample.app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.adapters.TaskAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var taskEditText: EditText
    private lateinit var addTaskButton: Button


    private lateinit var taskRecyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    val taskList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        taskEditText = findViewById(R.id.taskEditText)
        addTaskButton = findViewById(R.id.addTaskButton)

        //Recycler adapter binding
        taskRecyclerView = findViewById(R.id.taskRecyclerView)
        taskAdapter = TaskAdapter(taskList) { data ->
            removeTask(data)
        }


        taskRecyclerView.adapter = taskAdapter
        taskRecyclerView.layoutManager = LinearLayoutManager(this)


        addTaskButton.setOnClickListener {
            val task = taskEditText.text.toString()
            if (task.isNotEmpty()) {
                taskList.add(task)
                taskAdapter.notifyItemInserted(taskList.size - 1)
                taskEditText.text.clear()
            }
            Log.d("TaskList", taskList.toString())
        }


    }

    private fun removeTask(task: String) {
        var utils = Utils()
        utils.showAlertDialog(this, "Delete", "Are you sure?")




//        val position = taskList.indexOf(task)
//        if (position != -1) {
//            taskList.removeAt(position)
//            taskAdapter.notifyItemRemoved(position)
//        }
    }


}


class Person(var name: String)

//taskAdapter = TaskAdapter(taskList) { task -> removeTask(task) }
