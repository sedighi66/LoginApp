package org.itkarasa.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.itkarasa.loginapp.createViewModel
import org.itkarasa.loginapp.databinding.ActivityLoginBinding
import org.itkarasa.loginapp.di.DiHelper

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = createViewModel { DiHelper.getLoginViewModel(this) }
    }

}