package com.sample.app.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.app.R

class TaskAdapter(private val tasks: List<String>,
                  private val onTaskRemove: (String) -> Unit) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val taskTextView: TextView = itemView.findViewById(R.id.taskTextView)
        val deleteButton: ImageButton = itemView.findViewById(R.id.deleteButton)

        fun bind(item: String) {
            taskTextView.text = item
            deleteButton.setOnClickListener { onTaskRemove(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount() = tasks.size
}