package org.itkarasa.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.itkarasa.loginapp.LoginApp
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.di.AppModule
import org.itkarasa.loginapp.di.DaggerLoginComponent
import org.itkarasa.loginapp.view_models.LoginViewModel

class SignupActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = DaggerLoginComponent.builder().appModule(AppModule(this.application as LoginApp)).build().loginViewModel()

        login.setOnClickListener{
            viewModel.login(username.text.toString(), password.text.toString())
        }
    }



    companion object{
        private const val TAG = "SignupActivity"
    }

}