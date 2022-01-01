package id.nuryaz.myfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.nuryaz.myfriend.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private var operator = ""

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun operasi(view: View) {
        operator = when (view) {
            binding.btnPlus -> "+"
            binding.btnMinus -> "-"
            binding.btnMultiple -> "x"
            binding.btnDivider -> ":"
            else -> ""
        }
        binding.tvOperator.text = operator
    }

    fun hitung(view: View) {
        val input1 = binding.input1.text.toString()

        if (input1.isEmpty()) {
            binding.input1.error = "Belum diisi"
            binding.input1.requestFocus()
        }

        val input2 = binding.input2.text.toString()

        if (input2.isEmpty()) {
            binding.input2.error = "Belum diisi"
            binding.input2.requestFocus()
        }

        try {

            val number1 = input1.toFloat()
            val number2 = input2.toFloat()

            val hasil = when (operator) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "x" -> number1 * number2
                ":" -> number1 / number2
                else -> 0f
            }

            binding.tvResult.text = "$hasil"

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}