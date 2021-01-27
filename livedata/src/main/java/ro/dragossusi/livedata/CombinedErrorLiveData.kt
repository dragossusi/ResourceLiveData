package ro.dragossusi.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import ro.dragossusi.messagedata.MessageData

/**
 *
 * @author Dragos
 * @since 11.08.2020
 */
class CombinedErrorLiveData(
    private val main: LiveData<MessageData?>,
    private val fallback: LiveData<MessageData?>
) : MediatorLiveData<MessageData?>() {

    init {
        addSource(main) {
            value = it ?: fallback.value
        }
        addSource(fallback) {
            value = main.value ?: it
        }
    }

}