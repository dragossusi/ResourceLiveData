package ro.dragossusi.messagedata.livedata.validation

import androidx.lifecycle.LiveData
import ro.dragossusi.messagedata.MessageData


/**
 *
 * @since 9/3/20
 * @author dragos
 */
interface ValidationErrorContainer {
    val validationError: LiveData<MessageData?>
    var shown: Boolean
}