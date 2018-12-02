package com.reunitefamilies.reunitefamilies.taskList

import com.reunitefamilies.reunitefamilies.Api.TaskModel
import io.reactivex.Observable

interface TaskListContract {

    interface Interaction {
        fun getTasks(): Observable<List<TaskModel>>
    }

    interface Presentation {
        fun onResume()
    }
}