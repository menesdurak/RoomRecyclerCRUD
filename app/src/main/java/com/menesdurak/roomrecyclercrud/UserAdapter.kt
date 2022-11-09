package com.menesdurak.roomrecyclercrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var list = mutableListOf<User>()
    private var actionEdit: ((User) -> Unit)? = null
    private var actionDelete: ((User) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item_user_view_holder, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = list[position]
        holder.tvFirstName.text = user.firstName
        holder.tvLastName.text = user.lastName

        holder.actionEdit.setOnClickListener {
            actionEdit?.invoke(user)
        }
        holder.actionDelete.setOnClickListener {
            actionDelete?.invoke(user)
        }
    }

    override fun getItemCount(): Int = list.size

    fun setData(data: List<User>) {
        list.apply {
            clear()
            addAll(data)
        }
        notifyDataSetChanged()
    }

    fun setOnActionEditListener(callback: (User) -> Unit) {
        this.actionEdit = callback
    }

    fun setOnActionDeleteListener(callback: (User) -> Unit) {
        this.actionDelete = callback
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFirstName: TextView = itemView.findViewById<TextView>(R.id.tv_first_name)
        val tvLastName: TextView = itemView.findViewById<TextView>(R.id.tv_last_name)
        val actionEdit: ImageView = itemView.findViewById<ImageView>(R.id.action_edit)
        val actionDelete: ImageView = itemView.findViewById<ImageView>(R.id.action_delete)
    }
}