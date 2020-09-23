package ro.rachieru.dragos.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 17.08.2020
 */
open class ValidationLiveData<T>(
    liveData: LiveData<T>,
    mandatory: LiveData<Boolean>,
    private val validator: FieldValidator<T>
) : ValidationErrorContainer {

    constructor(
        liveData: LiveData<T>,
        mandatory: Boolean,
        validator: FieldValidator<T>
    ) : this(liveData, MutableLiveData(mandatory), validator)


    protected val _validationError = MediatorLiveData<ErrorData?>().apply {
        addSource(liveData) {
            check(it, mandatory.value)
        }
        addSource(mandatory) {
            check(liveData.value, it)
        }
    }

    override val validationError: LiveData<ErrorData?>
        get() = _validationError

    val show = MutableLiveData<Boolean?>(false)

    protected val _errorData: LiveData<ErrorData?> = ErrorLiveData(_validationError, show)
    val errorData: LiveData<ErrorData?>
        get() = _errorData

    override var shown: Boolean
        get() = show.value!!
        set(value) {
            show.value = value
        }

    fun check(data: T?, mandatory: Boolean?) {
        _validationError.value = validator(data, mandatory ?: true)
    }

}