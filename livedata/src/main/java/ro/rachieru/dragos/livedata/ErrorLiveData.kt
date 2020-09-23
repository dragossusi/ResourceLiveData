package ro.rachieru.dragos.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 09.07.2020
 */
class ErrorLiveData(
    private val errorData: LiveData<out ErrorData?>,
    private val show: LiveData<Boolean?>
) : MediatorLiveData<ErrorData?>() {

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