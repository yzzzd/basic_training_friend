package id.nuryaz.myfriend.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.nuryaz.myfriend.data.friend.Friend
import id.nuryaz.myfriend.data.friend.FriendDao

@Database(
    entities = [Friend::class],
    version = 1
)
abstract class MyDatabase: RoomDatabase() {
    abstract fun friendDao(): FriendDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context, MyDatabase::class.java, "my_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}