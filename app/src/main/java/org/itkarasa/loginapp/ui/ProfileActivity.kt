package org.itkarasa.loginapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.databinding.ActivityProfileBinding
import org.itkarasa.loginapp.di.DiHelper
import org.itkarasa.loginapp.view_models.LoginViewModel

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        rootView = binding.root
        setContentView(rootView)

        val user = intent.getSerializableExtra(LoginViewModel.USER_KEY) as User
        binding.viewModel = DiHelper.getProfileViewModel(this, user)
    }
}