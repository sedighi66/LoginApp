package org.itkarasa.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_admin.*
import org.itkarasa.loginapp.adapters.UserAdapter
import org.itkarasa.loginapp.createViewModel
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.databinding.ActivityAdminBinding
import org.itkarasa.loginapp.di.DiHelper

class AdminActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = createViewModel { DiHelper.getAdminViewModel(this) }

        userList.layoutManager = LinearLayoutManager(applicationContext)

        binding.viewModel!!.getUsers().observe(this, Observer {
           updateUi(it)
        })
    }

    private fun updateUi(users: List<User>){
        userList.adapter = UserAdapter(users, applicationContext, binding.viewModel!!)
    }
}