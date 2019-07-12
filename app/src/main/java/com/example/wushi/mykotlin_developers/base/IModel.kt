package com.example.wushi.mykotlin_developers.base

import io.reactivex.disposables.Disposable

/**
 * @author wsw
 *
 */
interface IModel {
    fun addDisposable(disposable: Disposable?)

    fun onDetach()
}