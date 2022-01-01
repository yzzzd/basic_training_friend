package id.nuryaz.myfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendEmail(view: View) {
        AlertDialog
            .Builder(this)
            .setTitle("Mengirim Email")
            .setMessage("Kamu menekan tombol kirim email")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}