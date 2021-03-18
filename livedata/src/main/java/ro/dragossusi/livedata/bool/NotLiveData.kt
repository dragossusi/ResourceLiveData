package ro.dragossusi.livedata.bool

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 *
 * @author dragos
 * @since 13/01/2021
 */
class NotLiveData(
    val liveData: LiveData<out Boolean?>
) : MediatorLiveData<Boolean?>() {

    init {
        addSource(liveData) {
            value = it?.not()
        }
    }

}