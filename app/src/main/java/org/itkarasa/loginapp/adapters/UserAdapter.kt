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

/**
 * Created by mohsen on 05,May,2020
 */
class UserAdapter(private val users: List<User>, private val context: Context) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val userItemBinding = UserItemBinding.inflate(layoutInflater, parent, false)
        return UserViewHolder(userItemBinding, context)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding(users[position])
    }

    open class UserViewHolder(
        private val binding: UserItemBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root), IItemEvent {

        fun binding(user: User) {
            binding.event = this
            binding.user = user
            binding.executePendingBindings()
        }

        override fun onClickItem(view: View){
            //TODO
            //go profile watch page
//            val intent = Intent(context, WatchProfileActivity::class.java)
//            intent.putExtra(WATCH_PROFILE_KEY, binding.user)
//            context.startActivity(intent)
        }

        override fun remove(view: View) {
            CoroutineScope(Dispatchers.IO).launch {
                //TODO
                //remove item
            }
        }


        companion object {
            private const val TAG = "Adapter"
            const val WATCH_PROFILE_KEY = "watch_profile_key"
        }
    }
}