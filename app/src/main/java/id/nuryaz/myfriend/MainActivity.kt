package id.nuryaz.myfriend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.nuryaz.myfriend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val people = People(
        photo = R.drawable.zahra,
        name = "Zahra",
        birthday = "6 Maret 2001",
        birthplace = "Kudus",
        about = "Halo, I am Zahra and I write Android Code to help women make the transition to successful engineer",
        email = "zahra01@gmail.com"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivProfile.setImageResource(people.photo)
        binding.tvName.text = people.name
        binding.tvBirthplace.text = people.birthplace
    }

    fun openDetail(view: View) {
        val detail = Intent(this, DetailActivity::class.java).apply {
            putExtra("photo", people.photo)
            putExtra("name", people.name)
            putExtra("bitrhday", people.birthday)
            putExtra("birthplace", people.birthplace)
            putExtra("about", people.about)
            putExtra("email", people.email)
        }

        startActivity(detail)
    }
}