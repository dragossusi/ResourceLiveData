package ro.rachieru.dragos.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import ro.rachieru.dragos.livedata.resource.CompletionResource

/**
 *
 * @author Dragos
 * @since 07.08.2020
 */
class LoadingLiveData(
    vararg liveData: LiveData<out CompletionResource?>
) : MediatorLiveData<Boolean>() {

    private val liveDatas = mutableListOf<LiveData<out CompletionResource>>(
        *liveData
    )

    init {
        val observer = Observer<CompletionResource?> {
            value = check()
        }
        liveDatas.forEach {
            addSource(it, observer)
        }
    }

    fun remove(liveData: LiveData<out CompletionResource?>): Boolean {
        return liveDatas.remove(liveData)
    }

    fun add(liveData: LiveData<out CompletionResource?>): Boolean {
        return liveDatas.add(liveData)
    }

    operator fun minusAssign(liveData: LiveData<out CompletionResource?>) {
        remove(liveData)
    }

    operator fun plusAssign(liveData: LiveData<out CompletionResource?>) {
        add(liveData)
    }

    private fun check(): Boolean {
        return liveDatas.any {
            it.value?.isLoading == true
        }
    }

}