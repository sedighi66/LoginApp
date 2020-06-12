package org.itkarasa.loginapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.itkarasa.loginapp.createViewModel
import org.itkarasa.loginapp.databinding.ActivitySignupBinding
import org.itkarasa.loginapp.di.DiHelper

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = createViewModel { DiHelper.getSignupViewModel(this) }
    }
}