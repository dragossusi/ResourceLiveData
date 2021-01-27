package ro.dragossusi.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import ro.dragossusi.messagedata.MessageData

/**
 *
 * @author Dragos
 * @since 09.07.2020
 */
class AllNullLiveData(
    private vararg val liveDatas: LiveData<MessageData?>
) : MediatorLiveData<Boolean>() {

    constructor(vararg liveDatas: ValidationErrorContainer) : this(
        *(liveDatas.map { it.validationError }.toTypedArray())
    )

    init {
        val observer = Observer<MessageData?> {
            value = check()
        }
        liveDatas.forEach {
            addSource(it, observer)
        }
    }

    private fun check(): Boolean {
        return liveDatas.all {
            it.value == null
        }
    }

}