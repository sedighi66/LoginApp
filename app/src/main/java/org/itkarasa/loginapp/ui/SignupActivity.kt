package org.itkarasa.loginapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.databinding.ActivitySignupBinding
import org.itkarasa.loginapp.di.DiHelper
import org.itkarasa.loginapp.view_models.SignupViewModel

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = DiHelper.getSignupViewModel(this)
    }
}