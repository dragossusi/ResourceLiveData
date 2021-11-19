package ro.dragossusi.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import ro.dragossusi.livedata.list.LiveDataCollection

/**
 *
 * @author Dragos
 * @since 09.07.2020
 */

class AllLiveData<T>(
    private vararg val liveDatas: LiveData<T>,
    private val check: (T?) -> Boolean
) : MediatorLiveData<Boolean>() {

    constructor(
        liveDatas: LiveDataCollection<T>,
        check: (T?) -> Boolean
    ) : this(
        liveDatas = liveDatas.toTypedArray(),
        check
    )

    init {
        val observer = Observer<T> {
            value = check()
        }
        liveDatas.forEach {
            addSource(it, observer)
        }
    }

    private fun check(): Boolean {
        return liveDatas.all {
            check(it.value)
        }
    }

}