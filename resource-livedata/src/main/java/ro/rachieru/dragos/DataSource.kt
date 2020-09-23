package ro.rachieru.dragos

import androidx.lifecycle.LiveDataScope
import ro.rachieru.dragos.livedata.extensions.completionResourceLiveData
import ro.rachieru.dragos.livedata.extensions.dataResourceLiveData
import ro.rachieru.dragos.livedata.resource.CompletionResource
import ro.rachieru.dragos.livedata.resource.DataResource
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author Dragos
 * @since 18.08.2020
 */
interface DataSource {

    val context: CoroutineContext

}

fun <T> DataSource.dataResourceLiveData(
    block: suspend LiveDataScope<DataResource<T>?>.() -> Unit
) = dataResourceLiveData<T>(context, block)

fun DataSource.completionResourceLiveData(
    block: suspend LiveDataScope<CompletionResource?>.() -> Unit
) = completionResourceLiveData(context, block)