package org.itkarasa.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.di.DiHelper
import org.itkarasa.loginapp.view_models.LoginViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = DiHelper.getLoginViewModel(this)

        login.setOnClickListener{
            viewModel.login(username.text.toString(), password.text.toString())
        }

        signUp.setOnClickListener {
            viewModel.signUp()
        }
    }



    companion object{
        private const val TAG = "MainActivity"
    }

}