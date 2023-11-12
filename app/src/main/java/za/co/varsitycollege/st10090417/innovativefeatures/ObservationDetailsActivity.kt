package za.co.varsitycollege.st10090417.innovativefeatures

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ObservationDetailsActivity : AppCompatActivity() {
    private lateinit var observationEntry: ObservationEntry

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observation_details)

        // Get the observation entry data from your data storage, for example
        // Retrieve entry based on the selected entry ID

        val btnShare = findViewById<Button>(R.id.btnShare)
        btnShare.setOnClickListener {
            shareImage()
        }
    }

    private fun shareImage() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM, observationEntry.imageUri)
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this bird observation!")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}
