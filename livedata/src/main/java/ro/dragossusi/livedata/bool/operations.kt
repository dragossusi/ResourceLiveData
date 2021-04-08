package ro.dragossusi.livedata.bool

import androidx.lifecycle.LiveData
import ro.dragossusi.livedata.bool.NotLiveData

/**
 *
 * @author dragos
 * @since 13/01/2021
 */
operator fun LiveData<out Boolean?>.not(): LiveData<out Boolean?> {
    return if (this is NotLiveData) liveData
    else NotLiveData(this)
}
