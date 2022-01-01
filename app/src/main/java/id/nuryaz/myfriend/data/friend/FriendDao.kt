package id.nuryaz.myfriend.data.friend

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FriendDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(friend: Friend)

    @Query("SELECT * FROM Friend")
    fun getAll(): LiveData<List<Friend>>

    @Query("SELECT * FROM Friend WHERE id = :id")
    fun get(id: Int): Friend?

    @Update
    fun update(friend: Friend)

    @Delete
    fun delete(friend: Friend)

    @Query("DELETE FROM Friend WHERE id = :id")
    fun delete(id: Int)
}
