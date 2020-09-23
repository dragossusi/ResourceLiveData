package ro.rachieru.dragos.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 *
 * @author Dragos
 * @since 16.07.2020
 */
class ObservableLiveData<T> constructor() : MediatorLiveData<T?>() {

    private var currentSource: LiveData<out T?>? = null

    fun setSource(source: LiveData<out T?>) {
        clear()
        synchronized(this) {
            currentSource = source
            addSource(source) {
                this.value = it
            }
        }
    }

    fun clear() {
        synchronized(this) {
            currentSource?.let {
                removeSource(it)
                value = null
            }
        }
    }

}