package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val todoList = mutableListOf(
            TodoModel("Todo 1", false),
            TodoModel("Todo 2", true),
            TodoModel("Todo 3", false),
            TodoModel("Todo 4", false),
            TodoModel("Todo 5", true),
            TodoModel("Todo 6", false)
        )

        val adapter  = TodoAdapter(todoList)
        var rvTodo = findViewById<RecyclerView>(R.id.rvTodos)

        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)

        var btn_add = findViewById<Button>(R.id.btn_add)
        var et_todo = findViewById<EditText>(R.id.etTodo)

        btn_add.setOnClickListener {
            val title = et_todo.text.toString()

            val todo = TodoModel(title, false)

            todoList.add(todo)

            adapter.notifyItemInserted(todoList.size-1)
        }

    }
}