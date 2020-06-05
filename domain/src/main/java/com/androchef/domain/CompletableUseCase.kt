package com.androchef.domain

import com.androchef.domain.executor.PostExecutionThread
import com.androchef.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

abstract class CompletableUseCase<in Params> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

    protected abstract fun buildUseCaseObservable(requestValues: Params? = null): Completable

    open fun execute(observer: DisposableCompletableObserver, params: Params? = null) {
        val completable = this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
        addDisposable(completable.subscribeWith(observer))
    }

    open fun execute(singleObserver: DisposableCompletableObserver, params: Params? = null, scheduler: Scheduler) {
        val single = this.buildUseCaseObservable(params).subscribeOn(
            Schedulers.from(threadExecutor)
        ).observeOn(scheduler)
        addDisposable(single.subscribeWith(singleObserver))
    }

    private val disposables = CompositeDisposable()

    fun dispose() {
        if (disposables.isDisposed.not()) disposables.dispose()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}
