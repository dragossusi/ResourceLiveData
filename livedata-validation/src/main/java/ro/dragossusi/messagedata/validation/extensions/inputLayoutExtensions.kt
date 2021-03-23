package ro.dragossusi.messagedata.validation.extensions

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.android.parser.toMessageDataParser

/**
 *
 * @author Dragos
 * @since 09.07.2020
 */
fun TextInputLayout.setTextInputError(
    errorData: MessageData?
) = setTextInputError(errorData?.getMessage(context.toMessageDataParser()), errorData != null)

fun EditText.setEditTextError(
    errorData: MessageData?
) = setEditTextError(errorData?.getMessage(context.toMessageDataParser()), errorData != null)

fun TextInputLayout.setTextInputError(
    errorMessage: CharSequence? = null,
    showError: Boolean = errorMessage != null
) {
    error = (if (showError) errorMessage
    else null)
}

fun EditText.setEditTextError(
    errorMessage: CharSequence? = null,
    showError: Boolean = errorMessage != null
) {
    if (showError) {
        error = errorMessage
    } else {
        error = null
    }
}