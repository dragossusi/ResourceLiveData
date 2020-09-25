package ro.dragossusi.livedata

import androidx.lifecycle.LiveData
import ro.rachieru.dragos.errordata.ErrorData


/**
 *
 * @since 9/3/20
 * @author dragos
 */
interface ValidationErrorContainer {
    val validationError: LiveData<ErrorData?>
    var shown: Boolean
}