package org.itkarasa.loginapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.databinding.ActivityProfileBinding
import org.itkarasa.loginapp.di.AppModule
import org.itkarasa.loginapp.di.DaggerProfileComponent
import org.itkarasa.loginapp.di.UserModule
import org.itkarasa.loginapp.view_models.LoginViewModel

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        rootView = binding.root
        setContentView(rootView)

        title = getString(R.string.profile)

        val user = intent.getSerializableExtra(LoginViewModel.USER_KEY) as User
        binding.viewModel =
            DaggerProfileComponent.builder().appModule(AppModule(this))
                .userModule(UserModule(user)).build().profileViewModel()

        rootView.findViewById<Button>(R.id.update).setOnClickListener {
            binding.viewModel!!.update()
        }

        rootView.findViewById<Button>(R.id.delete).setOnClickListener {
            binding.viewModel!!.delete()

        }
    }


    companion object {
        private const val TAG = "ProfileActivity"
    }

}