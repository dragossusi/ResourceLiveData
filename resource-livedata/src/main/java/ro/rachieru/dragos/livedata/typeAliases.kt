package ro.rachieru.dragos.livedata

import androidx.lifecycle.LiveData
import ro.rachieru.dragos.livedata.resource.CompletionResource
import ro.rachieru.dragos.livedata.resource.DataResource


/**
 *
 * @since 9/3/20
 * @author dragos
 */
typealias CompletionLiveData = LiveData<CompletionResource?>
typealias ResourceLiveData<T> = LiveData<DataResource<T>?>