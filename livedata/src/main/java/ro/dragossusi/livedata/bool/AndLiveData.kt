package ro.dragossusi.livedata.bool

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/**
 *
 * @author dragos
 * @since 13/01/2021
 */
class AndLiveData(
    private vararg val liveDatas: LiveData<out Boolean?>,
    val defaultIfNull: Boolean = false
) : MediatorLiveData<Boolean>() {

    init {
        val observer = Observer<Boolean?> {
            value = check()
        }
        liveDatas.forEach {
            addSource(it, observer)
        }
    }

    private fun check(): Boolean {
        return liveDatas.all {
            it.value ?: defaultIfNull
        }
    }

}