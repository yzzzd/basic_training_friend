package id.nuryaz.myfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.nuryaz.myfriend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onPause() {
        super.onPause()
        counter += 1
        binding.tvCounter.text = "$counter"
    }
}