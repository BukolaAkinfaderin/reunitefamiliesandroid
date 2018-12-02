package com.reunitefamilies.reunitefamilies.taskList

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.reunitefamilies.reunitefamilies.R

class TaskListActivity: AppCompatActivity() {

    private lateinit var presenter: TaskListContract.Presentation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)
        TaskListDependencies().inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }


    fun provide(presenter: TaskListContract.Presentation) {
        this.presenter = presenter
    }
}