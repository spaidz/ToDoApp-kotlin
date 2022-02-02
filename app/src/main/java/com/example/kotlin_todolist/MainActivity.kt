package com.example.kotlin_todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var TodoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TodoAdapter = TodoAdapter(mutableListOf())

        rvToDoItems.adapter = TodoAdapter
        rvToDoItems.layoutManager = LinearLayoutManager(this)

        btnAddToDo.setOnClickListener {
            val todoTitle = etTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = ToDo(todoTitle)
                TodoAdapter.addTodo(todo)
                etTitle.text.clear()
            }
        }
        btnDeleteToDo.setOnClickListener {
            TodoAdapter.deleteDoneTodos()
        }


    }
}