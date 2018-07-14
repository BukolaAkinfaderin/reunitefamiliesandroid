package com.reunitefamilies.reunitefamilies.main

class LandingPresenter(val interactor: LandingInteractor, val coordinator: LandingCoordinator): LandingContract.Presentation {
    override fun openRegistrationIfNeeded() {
        coordinator.openRegistrationAndExit()
    }
}