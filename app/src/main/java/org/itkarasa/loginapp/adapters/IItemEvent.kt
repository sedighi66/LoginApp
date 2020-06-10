package org.itkarasa.loginapp.adapters

import android.view.View

/**
 * Created by mohsen on 03,June,2020
 */
interface IItemEvent {
    fun onClickItem(view: View)
    fun remove(view: View)
}