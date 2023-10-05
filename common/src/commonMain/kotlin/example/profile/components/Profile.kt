package example.profile.components.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import example.profile.components.talk.SpeakerInfo
import example.profile.components.talk.TalkInfo
import example.profile.constants.DarkGrey
import example.profile.components.talk.SaveButton
import example.profile.viewmodel.ProfileViewModel
import make_friends_with_kotlin_devs.common.generated.resources.Res
import make_friends_with_kotlin_devs.common.generated.resources.background
import org.jetbrains.compose.resources.painterResource

@Composable
fun Profile(vm: ProfileViewModel) {
    LaunchedEffect(Unit) {
        vm.getTalkInfo()
    }

    vm.talk?.let {
        BoxWithConstraints(modifier = Modifier.fillMaxHeight().background(Color.DarkGrey)) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Column(
                    modifier = Modifier.paint(
                        painterResource(Res.drawable.background),
                        contentScale = ContentScale.Crop
                    )
                ) {
                    SaveButton(
                        onClick = { vm.updateTalkInfo() },
                        modifier = Modifier
                            .padding(PaddingValues(top = 20.dp, end = 20.dp))
                            .align(Alignment.End)
                    )
                    SpeakerInfo(it.speaker, vm) { vm.patchTalkInfo(vm.talk?.copy(speaker = it)) }
                }
                Column(modifier = Modifier.background(Color.DarkGrey)) {
                    TalkInfo(it, vm) { vm.patchTalkInfo(it) }
                }
            }
        }
    } ?: Text(vm.serverErrorMessage.ifEmpty { "Loading..." })
}
