package org.itkarasa.loginapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.itkarasa.loginapp.adapters.UserAdapter.UserViewHolder.Companion.WATCH_PROFILE_KEY
import org.itkarasa.loginapp.createViewModel
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.databinding.ActivityProfileWatchBinding
import org.itkarasa.loginapp.di.DiHelper

class ProfileWatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileWatchBinding
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileWatchBinding.inflate(layoutInflater)
        rootView = binding.root
        setContentView(rootView)

        val user = intent.getSerializableExtra(WATCH_PROFILE_KEY) as User
        binding.viewModel = createViewModel { DiHelper.getProfileWatchViewModel(this, user) }
    }
}