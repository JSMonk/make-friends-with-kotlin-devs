package example.profile.components.talk

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import example.profile.api.model.Talk
import example.profile.viewmodel.ProfileViewModel

@Composable
fun TalkInfo(
    talk: Talk,
    vm: ProfileViewModel,
    onValueChange: (Talk) -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TalkTitle(talk.title) { onValueChange(talk.copy(title = it)) }
        TalkDescription(talk.description) { onValueChange(talk.copy(description = it)) }
    }
}