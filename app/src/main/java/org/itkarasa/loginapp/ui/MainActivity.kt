package org.itkarasa.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.databinding.ActivityMainBinding
import org.itkarasa.loginapp.di.DiHelper
import org.itkarasa.loginapp.view_models.LoginViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = DiHelper.getLoginViewModel(this)
    }



    companion object{
        private const val TAG = "MainActivity"
    }

}