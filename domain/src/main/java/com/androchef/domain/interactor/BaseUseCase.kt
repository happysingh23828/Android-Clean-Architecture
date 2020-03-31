package com.androchef.domain.interactor

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


abstract class BaseUseCase<REQ : BaseUseCase.Params?, RES : BaseUseCase.ResponseValue> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {
    private var requestValues: REQ? = null

    protected abstract fun buildUseCaseObservable(requestValues: REQ? = null): Single<RES>

    /**
     * Executes the current use case.
     */
    open fun execute(singleObserver: DisposableSingleObserver<RES>) {
        val single = this.buildUseCaseObservable(requestValues).subscribeOn(
            Schedulers.from(threadExecutor)
        ).observeOn(postExecutionThread.scheduler) as Single<RES>
        addDisposable(single.subscribeWith(singleObserver))
    }

    open fun execute(singleObserver: DisposableSingleObserver<RES>, scheduler: Scheduler) {
        val single = this.buildUseCaseObservable(requestValues).subscribeOn(
            Schedulers.from(threadExecutor)
        ).observeOn(scheduler) as Single<RES>
        addDisposable(single.subscribeWith(singleObserver))
    }


    private val disposables = CompositeDisposable()

    fun dispose() {
        if (disposables.isDisposed.not()) disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    /**
     * Implement this interfaces for I/O values.
     * [Params] input parameters for the UseCase
     * [EmptyParam] empty parameter for the UseCase
     * [ResponseValue] response data for this UseCase
     */
    interface Params

    interface EmptyParam : Params

    interface ResponseValue
}