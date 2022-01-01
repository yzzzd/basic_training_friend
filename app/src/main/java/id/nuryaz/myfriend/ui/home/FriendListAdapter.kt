package id.nuryaz.myfriend.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.nuryaz.myfriend.data.friend.Friend
import id.nuryaz.myfriend.databinding.ItemFriendBinding

class FriendListAdapter(private val items: List<Friend>, private val onItemClick: (friend: Friend) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FriendViewHolder(ItemFriendBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as FriendViewHolder
        viewHolder.bind(items[position])
        viewHolder.itemView.setOnClickListener { onItemClick(items[position]) }
    }

    override fun getItemCount() = items.size

    companion object {
        class FriendViewHolder(private val binding: ItemFriendBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(friend: Friend) {
                binding.tvName.text = friend.name
                binding.tvIg.text = "@${friend.ig}"
                binding.tvDesc.text = friend.description
            }
        }
    }
}