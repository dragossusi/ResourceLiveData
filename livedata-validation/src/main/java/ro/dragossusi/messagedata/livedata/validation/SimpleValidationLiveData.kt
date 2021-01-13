package ro.dragossusi.messagedata.livedata.validation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ro.dragossusi.livedata.FieldValidator

/**
 *
 * @author Dragos
 * @since 17.08.2020
 */
open class SimpleValidationLiveData<T>(
    liveData: LiveData<T>,
    mandatory: LiveData<Boolean>,
    private val validator: FieldValidator<T>
) : ValidationLiveData<T>(liveData, mandatory) {

    constructor(
        liveData: LiveData<T>,
        mandatory: Boolean,
        validator: FieldValidator<T>
    ) : this(liveData, MutableLiveData(mandatory), validator)

    override fun check(data: T?, mandatory: Boolean): MessageData? {
        return validator(data, mandatory ?: true)
    }

}