package example.profile.components.talk

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import example.profile.api.model.Speaker
import example.profile.viewmodel.ProfileViewModel

@Composable
fun SpeakerInfo(
    speaker: Speaker,
    vm: ProfileViewModel,
    onValueChange: (Speaker) -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpeakerImage(speaker.image) { onValueChange(speaker.copy(image = it)) }
        SpeakerName(speaker.name) { onValueChange(speaker.copy(name = it)) }
        SpeakerCompany(speaker.position) { onValueChange(speaker.copy(position = it)) }
        SpeakerDescription(speaker.about) { onValueChange(speaker.copy(about = it)) }
    }
}