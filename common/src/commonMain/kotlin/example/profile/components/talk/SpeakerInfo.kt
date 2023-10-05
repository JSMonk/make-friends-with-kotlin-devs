package example.profile.components.talk

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import example.profile.api.model.Speaker
import example.profile.api.model.Talk
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
        SpeakerImage(speaker.image, Modifier.padding(PaddingValues(bottom = 15.dp))) { onValueChange(speaker.copy(image = it)) }
        SpeakerName(speaker.name, vm.validationErrorFor(Talk::speaker, Speaker::name)) { onValueChange(speaker.copy(name = it)) }
        SpeakerCompany(speaker.position, vm.validationErrorFor(Talk::speaker, Speaker::position)) { onValueChange(speaker.copy(position = it)) }
        SpeakerDescription(speaker.about, vm.validationErrorFor(Talk::speaker, Speaker::about)) { onValueChange(speaker.copy(about = it)) }
    }
}