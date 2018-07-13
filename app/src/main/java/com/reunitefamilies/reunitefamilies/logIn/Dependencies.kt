package com.reunitefamilies.reunitefamilies.logIn

class Dependencies {
    fun inject(activity: LogInActivity) {
        val interactor = Interactor()
        val presenter = Presenter(interactor)
        val coordinator = Coordinator(presenter)

        activity.provide(coordinator, presenter)
    }
}