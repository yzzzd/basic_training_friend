package id.nuryaz.myfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.nuryaz.myfriend.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private lateinit var people: People

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        people = People(
            photo = intent.getIntExtra("photo", 0),
            name = intent.getStringExtra("name") ?: "",
            birthday = intent.getStringExtra("bitrhday") ?: "",
            birthplace = intent.getStringExtra("birthplace") ?: "",
            about = intent.getStringExtra("about") ?: "",
            email = intent.getStringExtra("email") ?: ""
        )

        binding.ivProfile.setImageResource(people.photo)
        binding.tvName.text = people.name
        binding.tvBirthday.text = people.birthday
        binding.tvBirthplace.text = people.birthplace
        binding.tvAbout.text = people.about
        binding.tvEmail.text = people.email
    }
}