package com.example.wushi.mykotlin_developers.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.OnLifecycleEvent
import io.reactivex.disposables.CompositeDisposable
import org.greenrobot.eventbus.EventBus

/**
 * @author wsw
 */
abstract class BasePresenter<M : IModel, V : IView> : IPresenter<V>, LifecycleObserver {

    protected var mView: V? = null
    protected var mModel: M? = null
    private var mCompositeDisposable: CompositeDisposable? = null

    private val isViewAttached: Boolean
        get() = mView != null

    /**
     * 创建 Model
     */
    abstract fun createModel(): M?

    /**
     * 是否使用 EventBus
     */
    open fun useEventBus(): Boolean = false

    override fun attachView(mView: V) {
        this.mView = mView
        mModel = createModel()
        if (mView is LifecycleOwner) {
            if (mModel != null && mModel is LifecycleObserver) {
                (mView as LifecycleOwner).lifecycle.addObserver(mModel as LifecycleObserver)
            }
        }
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
    }

    open fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }


    override fun detachView() {
        if (useEventBus()) {
            EventBus.getDefault().unregister(this)
        }
        //确保Activity结束时候取消掉所有的订阅
        unDispose()
        mModel?.onDetach()
        this.mView = null
        this.mModel = null
    }

    private fun unDispose() {
        mCompositeDisposable?.clear()  // 保证Activity结束时取消
        mCompositeDisposable = null
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner) {
        // detachView()
        owner.lifecycle.removeObserver(this)
    }

    private class MvpViewNotAttachedException internal constructor() :
        RuntimeException("Please call IPresenter.attachView(IBaseView) before" + " requesting data to the IPresenter")


}