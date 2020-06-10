package org.itkarasa.loginapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.di.Modules.AppModule
import org.itkarasa.loginapp.di.components.DaggerSignupComponent
import org.itkarasa.loginapp.view_models.SignupViewModel

class SignupActivity : AppCompatActivity() {

    private lateinit var viewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        title = getString(R.string.signup_page_name)

        viewModel =
            DaggerSignupComponent.builder().appModule(
                AppModule(
                    this
                )
            )
                .build().signUpViewModel()

        signUp.setOnClickListener {
            viewModel.signUp(
                username.text.toString(),
                password.text.toString(),
                confirmPassword.text.toString(),
                fullName.text.toString()
            )
        }
    }


    companion object {
        private const val TAG = "SignupActivity"
    }

}