package example.profile.services

import example.profile.api.model.Talk
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

@JsExport
class ProfileViewModel {
    fun fetchTalkInfo(): Promise<Talk> = GlobalScope.promise { example.profile.services.fetchTalkInfo() }
    fun updateTalkInfo(talk: Talk): Promise<Any> = GlobalScope.promise { example.profile.services.updateTalkInfo(talk) }
}