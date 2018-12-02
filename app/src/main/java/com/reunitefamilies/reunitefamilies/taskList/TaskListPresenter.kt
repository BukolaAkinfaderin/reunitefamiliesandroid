package com.reunitefamilies.reunitefamilies.taskList

class TaskListPresenter(private val interactor: TaskListContract.Interaction) : TaskListContract.Presentation {

    override fun onResume() {
        interactor.getTasks().subscribe {

        }
    }
}