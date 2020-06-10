package org.itkarasa.loginapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_admin.*
import org.itkarasa.loginapp.R
import org.itkarasa.loginapp.adapters.UserAdapter
import org.itkarasa.loginapp.di.AppModule
import org.itkarasa.loginapp.di.DaggerAdminComponent
import org.itkarasa.loginapp.view_models.AdminViewModel

class AdminActivity : AppCompatActivity() {

    private lateinit var viewModel: AdminViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        title = getString(R.string.admin)

        viewModel = DaggerAdminComponent.builder().appModule(AppModule(this)).build().adminViewModel()

        userList.layoutManager = LinearLayoutManager(applicationContext)

        viewModel.getUsers().observe(this, Observer {
            userList.adapter = UserAdapter(it, applicationContext)
        })
    }



    companion object{
        private const val TAG = "MainActivity"
    }

}