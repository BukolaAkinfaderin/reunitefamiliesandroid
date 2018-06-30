package com.reunitefamilies.reunitefamilies.signIn

class Dependencies {
    fun inject(activity: SignInActivity) {
        val interactor = Interactor()
        val presenter = Presenter(interactor)
        val coordinator = Coordinator(presenter)

        activity.provide(coordinator, presenter)
    }
}