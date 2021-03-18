package ro.dragossusi.messagedata.livedata.validation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import ro.dragossusi.livedata.ErrorLiveData
import ro.dragossusi.livedata.ValidationErrorContainer
import ro.dragossusi.messagedata.MessageData

/**
 *
 * @author Dragos
 * @since 17.08.2020
 */
abstract class ValidationLiveData<T>(
    private val liveData: LiveData<T>,
    private val mandatory: LiveData<Boolean>
) : ValidationErrorContainer {

    constructor(
        liveData: LiveData<T>,
        mandatory: Boolean
    ) : this(liveData, MutableLiveData(mandatory))


    protected val _validationError = MediatorLiveData<MessageData?>().apply {
        addSource(liveData) {
            value = check(it, mandatory.value ?: true)
        }
        addSource(mandatory) {
            value = check(liveData.value, it ?: true)
        }
    }

    protected fun addSource(source: LiveData<*>) {
        _validationError.addSource(source) {
            _validationError.value = check(liveData.value, mandatory.value ?: true)
        }
    }

    override val validationError: LiveData<MessageData?>
        get() = _validationError

    val show = MutableLiveData<Boolean?>(false)

    protected val _errorData: LiveData<MessageData?> = ErrorLiveData(_validationError, show)
    val errorData: LiveData<MessageData?>
        get() = _errorData

    override var shown: Boolean
        get() = show.value!!
        set(value) {
            show.value = value
        }

    abstract fun check(data: T?, mandatory: Boolean): MessageData?

}