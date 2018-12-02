package com.reunitefamilies.reunitefamilies.taskList

import com.reunitefamilies.reunitefamilies.Api.TaskModel
import com.reunitefamilies.reunitefamilies.Api.apiservice
import io.reactivex.Observable

class TaskListInteractor : TaskListContract.Interaction {

    override fun getTasks(): Observable<List<TaskModel>> {
        return apiservice.getTasks()
    }
}