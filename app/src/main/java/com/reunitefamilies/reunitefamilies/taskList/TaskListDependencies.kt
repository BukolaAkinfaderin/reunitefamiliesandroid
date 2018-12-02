package com.reunitefamilies.reunitefamilies.taskList

import android.app.Activity

class TaskListDependencies {

    fun inject(activity: Activity) {
        if (activity is TaskListActivity) {
            val interactor = TaskListInteractor()
            val presenter = TaskListPresenter(interactor)
            (activity as TaskListActivity).provide(presenter)
        }
    }
}