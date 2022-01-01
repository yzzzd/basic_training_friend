package id.nuryaz.myfriend.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import id.nuryaz.myfriend.R
import id.nuryaz.myfriend.data.MyDatabase
import id.nuryaz.myfriend.data.friend.Friend
import id.nuryaz.myfriend.data.friend.FriendDao
import id.nuryaz.myfriend.databinding.ActivityDetailFriendBinding
import id.nuryaz.myfriend.ui.add.AddFriendActivity
import java.util.concurrent.Executors

class DetailFriendActivity : AppCompatActivity() {

    private val binding: ActivityDetailFriendBinding by lazy {
        ActivityDetailFriendBinding.inflate(layoutInflater)
    }

    private val friendDao: FriendDao by lazy {
        MyDatabase.getDatabase(this).friendDao()
    }

    private var friendId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        friendId = intent.getIntExtra("id", 0)

        Executors.newSingleThreadExecutor().execute {
            val friend = friendDao.get(friendId)

            binding.tvName.text = friend?.name
            binding.tvIg.text = "@${friend?.ig}"
            binding.tvDesc.text = friend?.description
        }
    }

    fun edit(view: View) {
        startActivity(Intent(this, AddFriendActivity::class.java).apply {
            putExtra("id", friendId)
        })
        finish()
    }

    fun delete(view: View) {
        AlertDialog
            .Builder(this)
            .setMessage(R.string.dialog_delete_friend)
            .setPositiveButton(R.string.btn_delete) { dialog, _ ->
                Executors.newSingleThreadExecutor().execute {
                    friendDao.delete(friendId)
                }
                dialog.dismiss()
                finish()
            }
            .setNegativeButton(R.string.btn_cancel) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}