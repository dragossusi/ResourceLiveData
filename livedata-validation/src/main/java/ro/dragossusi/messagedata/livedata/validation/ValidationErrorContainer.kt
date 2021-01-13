package ro.dragossusi.messagedata.livedata.validation

import androidx.lifecycle.LiveData
import ro.dragossusi.messagedata.messagedata


/**
 *
 * @since 9/3/20
 * @author dragos
 */
interface ValidationErrorContainer {
    val validationError: LiveData<ErrorData?>
    var shown: Boolean
}