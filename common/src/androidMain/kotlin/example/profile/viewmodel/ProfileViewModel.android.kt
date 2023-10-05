package example.profile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope

actual typealias ViewModel = ViewModel

actual val ViewModel.viewModelScope: CoroutineScope
    get() = viewModelScope