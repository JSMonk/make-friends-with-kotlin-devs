package example.profile.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope

actual abstract class ViewModel

actual val ViewModel.viewModelScope: CoroutineScope
    get() = GlobalScope