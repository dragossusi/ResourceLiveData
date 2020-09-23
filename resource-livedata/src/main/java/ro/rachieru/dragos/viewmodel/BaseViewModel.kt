package ro.rachieru.dragos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ro.rachieru.dragos.livedata.LoadingLiveData
import ro.rachieru.dragos.livedata.ObservableLiveData
import ro.rachieru.dragos.livedata.resource.CompletionResource
import ro.rachieru.dragos.livedata.resource.DataResource


/**
 *
 * @since 9/23/20
 * @author dragos
 */
abstract class BaseViewModel : ViewModel() {

    protected val _loadingLiveData = LoadingLiveData()

    val loadingLiveData: LiveData<Boolean>
        get() = _loadingLiveData

    protected fun <T> observableData(): ObservableLiveData<DataResource<T>> {
        val observable = ObservableLiveData<DataResource<T>>()
        _loadingLiveData += observable
        return observable
    }

    protected fun observableCompletion(): ObservableLiveData<CompletionResource> {
        val observable = ObservableLiveData<CompletionResource>()
        _loadingLiveData += observable
        return observable
    }

    fun addLoadingSource(source: LiveData<out CompletionResource?>) {
        _loadingLiveData += source
    }

    fun removeLoadingSource(source: LiveData<out CompletionResource?>) {
        _loadingLiveData -= source
    }

}