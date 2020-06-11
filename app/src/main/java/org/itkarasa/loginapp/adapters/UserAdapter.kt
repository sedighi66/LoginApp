package org.itkarasa.loginapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.itkarasa.loginapp.database.entity.User
import org.itkarasa.loginapp.databinding.UserItemBinding
import org.itkarasa.loginapp.repository.UserRepository
import org.itkarasa.loginapp.ui.ProfileWatchActivity
import org.itkarasa.loginapp.view_models.AdminViewModel

/**
 * Created by mohsen on 05,May,2020
 */
class UserAdapter(
    private val users: List<User>, private val context: Context,
    private val adminViewModel: AdminViewModel
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val userItemBinding = UserItemBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(userItemBinding, context, adminViewModel)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding(users[position])
    }

    open class UserViewHolder(
        private val binding: UserItemBinding,
        private val context: Context,
        private val adminViewModel: AdminViewModel
    ) :
        RecyclerView.ViewHolder(binding.root), IItemEvent {

        fun binding(user: User) {
            binding.event = this
            binding.user = user
            binding.executePendingBindings()
        }

        override fun onClickItem(view: View) {

            val intent = Intent(context, ProfileWatchActivity::class.java)
            intent.putExtra(WATCH_PROFILE_KEY, binding.user)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

        override fun remove(view: View) {
            adminViewModel.removeUser(binding.user!!)
        }


        companion object {
            const val WATCH_PROFILE_KEY = "watch_profile_key"
        }
    }
}