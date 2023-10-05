package example.profile.viewmodel

import kotlinx.coroutines.CoroutineScope

actual abstract class ViewModel
actual val ViewModel.viewModelScope: CoroutineScope
    get() = error("Should be never used")