package example.profile

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import example.profile.components.components.Profile
import example.profile.viewmodel.ProfileViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val profileViewModel = ProfileViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            Profile(profileViewModel)
        }
    }
}
