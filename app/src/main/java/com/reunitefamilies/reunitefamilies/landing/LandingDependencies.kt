package com.reunitefamilies.reunitefamilies.landing

class LandingDependencies {
    fun inject(activity: LandingActivity) {
        val interactor = LandingInteractor()
        val coordinator = LandingCoordinator(activity)
        val presenter = LandingPresenter(interactor, coordinator)

        activity.provide(presenter)
    }
}