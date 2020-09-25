package ro.dragossusi.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 11.08.2020
 */
class CombinedErrorLiveData(
    private val main: LiveData<ErrorData?>,
    private val fallback: LiveData<ErrorData?>
) : MediatorLiveData<ErrorData?>() {

    init {
        addSource(main) {
            value = it ?: fallback.value
        }
        addSource(fallback) {
            value = main.value ?: it
        }
    }

}