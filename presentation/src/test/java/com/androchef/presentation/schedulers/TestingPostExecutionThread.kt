package com.androchef.presentation.schedulers

import com.androchef.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestingPostExecutionThread : PostExecutionThread {
    override val scheduler: Scheduler = Schedulers.trampoline()
}
