package ro.dragossusi.messagedata.livedata.validation

/**
 *
 * @author Dragos
 * @since 17.07.2020
 */
fun interface StringValidator {
    fun validateString(text: CharSequence): Boolean
}

fun Regex.toStringValidator(): StringValidator {
    return StringValidator(this::matches)
}