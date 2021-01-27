package ro.dragossusi.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import ro.dragossusi.messagedata.MessageData

/**
 *
 * @author Dragos
 * @since 09.07.2020
 */
class ErrorLiveData(
    private val errorData: LiveData<out MessageData?>,
    private val show: LiveData<Boolean?>
) : MediatorLiveData<MessageData?>() {

    fun check() {
        value = if (show.value == true) {
            errorData.value
        } else null
    }

    init {
        addSource(errorData) { check() }
        addSource(show) { check() }
    }

}