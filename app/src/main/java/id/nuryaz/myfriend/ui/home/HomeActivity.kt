package id.nuryaz.myfriend.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.nuryaz.myfriend.data.MyDatabase
import id.nuryaz.myfriend.data.friend.Friend
import id.nuryaz.myfriend.data.friend.FriendDao
import id.nuryaz.myfriend.databinding.ActivityHomeBinding
import id.nuryaz.myfriend.ui.add.AddFriendActivity
import id.nuryaz.myfriend.ui.detail.DetailFriendActivity

class HomeActivity : AppCompatActivity() {

    private val binding: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    private val friendDao: FriendDao by lazy {
        MyDatabase.getDatabase(this).friendDao()
    }

    private lateinit var friendListAdapter: FriendListAdapter
    private var friends = ArrayList<Friend>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        friendListAdapter = FriendListAdapter(friends) {
            startActivity(Intent(this, DetailFriendActivity::class.java).apply {
                putExtra("id", it.id)
            })
        }

        binding.rvFriend.adapter = friendListAdapter

        // observer dari tabel friend, sehingga jika terjadi perubahan data kan mengembalikan nilai List<Friend>
        friendDao.getAll().observe(this, {
            friends.clear()
            friends.addAll(it)
            friendListAdapter.notifyDataSetChanged()
        })
    }

    fun add(view: View) {
        startActivity(Intent(this, AddFriendActivity::class.java))
    }
}