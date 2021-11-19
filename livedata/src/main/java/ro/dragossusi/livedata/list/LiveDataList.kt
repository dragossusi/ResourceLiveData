package ro.dragossusi.livedata.list

import androidx.lifecycle.LiveData
import ro.dragossusi.livedata.AllLiveData
import ro.dragossusi.livedata.AnyLiveData

typealias LiveDataList<T> = List<LiveData<T>>
typealias LiveDataCollection<T> = Collection<LiveData<T>>
typealias LiveDataArray<T> = Array<LiveData<T>>

//any
@Suppress("unused")
fun <T> LiveDataCollection<T>.any(
    check: (T?) -> Boolean
) {
    AnyLiveData(this, check)
}

@Suppress("unused")
fun <T> LiveDataArray<T>.any(
    check: (T?) -> Boolean
) {
    AnyLiveData(liveDatas = this, check)
}

//all
@Suppress("unused")
fun <T> LiveDataCollection<T>.all(
    check: (T?) -> Boolean
) {
    AllLiveData(this, check)
}

@Suppress("unused")
fun <T> LiveDataArray<T>.all(
    check: (T?) -> Boolean
) {
    AllLiveData(liveDatas = this, check)
}