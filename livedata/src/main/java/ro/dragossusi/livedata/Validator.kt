package ro.dragossusi.livedata

import ro.rachieru.dragos.errordata.ErrorData

/**
 *
 * @author Dragos
 * @since 17.08.2020
 *
 * return   null if no error found
 *          an errordata if there's an error
 */
typealias FieldValidator<T> = (T?, mandatory: Boolean) -> ErrorData?