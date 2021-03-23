package tech.modex.mobile.banking.livedata.bool

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/**
 *
 * @author dragos
 * @since 13/01/2021
 */
class OrLiveData(
    private vararg val liveDatas: LiveData<Boolean>,
    val defaultIfNull: Boolean = false
) : MediatorLiveData<Boolean>() {

    init {
        val observer = Observer<Boolean> {
            value = check()
        }
        liveDatas.forEach {
            addSource(it, observer)
        }
    }

    private fun check(): Boolean {
        return liveDatas.any {
            it.value ?: defaultIfNull
        }
    }

}