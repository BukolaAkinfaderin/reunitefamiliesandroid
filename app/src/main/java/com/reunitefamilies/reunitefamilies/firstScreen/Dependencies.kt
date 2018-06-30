package com.reunitefamilies.reunitefamilies.firstScreen

class Dependencies {
    fun inject(activity: ReuniteFamilies) {
        val interactor = Interactor()
        val presenter = Presenter(interactor)
        val coordinator = Coordinator(presenter)

        activity.provide(coordinator, presenter)
    }
}