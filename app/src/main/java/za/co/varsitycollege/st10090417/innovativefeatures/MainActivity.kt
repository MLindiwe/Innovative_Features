package za.co.varsitycollege.st10090417.innovativefeatures

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShareApp = findViewById<Button>(R.id.btnShareApp)
        btnShareApp.setOnClickListener {
            shareApplication()
        }
    }

    private fun shareApplication() {
        val appPackageName = packageName
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this bird observation app:\nhttps://play.google.com/store/apps/details?id=$appPackageName")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}