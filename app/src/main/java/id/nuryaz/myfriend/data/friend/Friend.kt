package id.nuryaz.myfriend.data.friend

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Friend(var name: String, var ig: String, var description: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}