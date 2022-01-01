package id.nuryaz.myfriend.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.textfield.TextInputEditText
import id.nuryaz.myfriend.R
import id.nuryaz.myfriend.data.MyDatabase
import id.nuryaz.myfriend.data.friend.Friend
import id.nuryaz.myfriend.data.friend.FriendDao
import id.nuryaz.myfriend.databinding.ActivityAddFriendBinding
import java.util.concurrent.Executors

class AddFriendActivity : AppCompatActivity() {

    private val binding: ActivityAddFriendBinding by lazy {
        ActivityAddFriendBinding.inflate(layoutInflater)
    }

    private val friendDao: FriendDao by lazy {
        MyDatabase.getDatabase(this).friendDao()
    }

    private var friendId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        friendId = intent.getIntExtra("id", 0)

        if (friendId != 0) {
            Executors.newSingleThreadExecutor().execute {
                val friend = friendDao.get(friendId)

                runOnUiThread {
                    binding.inputName.setText(friend?.name)
                    binding.inputIg.setText(friend?.ig)
                    binding.inputDesc.setText(friend?.description)
                }
            }
        }
    }

    private fun showError(input: TextInputEditText) {
        input.error = getString(R.string.error_empty)
        input.requestFocus()
    }

    fun save(view: View) {
        val strName = binding.inputName.text.toString()

        if (strName.isEmpty()) {
            showError(binding.inputName)
            return
        }

        val strInstagram = binding.inputIg.text.toString()

        if (strInstagram.isEmpty()) {
            showError(binding.inputIg)
            return
        }

        val strDescription = binding.inputDesc.text.toString()

        if (strDescription.isEmpty()) {
            showError(binding.inputDesc)
            return
        }

        val newFriend = Friend(name = strName, ig = strInstagram, description = strDescription)

        Executors.newSingleThreadExecutor().execute {
            if (friendId != 0) {
                newFriend.id = friendId
                friendDao.update(newFriend)
            } else {
                friendDao.insert(newFriend)
            }
            finish()
        }
    }
}