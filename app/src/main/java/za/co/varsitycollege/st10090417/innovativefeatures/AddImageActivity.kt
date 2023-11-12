package za.co.varsitycollege.st10090417.innovativefeatures

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AddImageActivity : AppCompatActivity() {
    private lateinit var btnChooseImage: Button
    private lateinit var imgSelected: ImageView
    private lateinit var etBirdName: EditText
    private lateinit var etObservationDetails: EditText

    private val PICK_IMAGE_REQUEST = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_image)

        btnChooseImage = findViewById(R.id.btnChooseImage)
        imgSelected = findViewById(R.id.imgSelected)
        etBirdName = findViewById(R.id.etBirdName)
        etObservationDetails = findViewById(R.id.etObservationDetails)

        btnChooseImage.setOnClickListener {
            openGallery()
        }

        findViewById<Button>(R.id.btnSaveEntry).setOnClickListener {
            saveObservationEntry()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    private fun saveObservationEntry() {
        val birdName = etBirdName.text.toString()
        val observationDetails = etObservationDetails.text.toString()

        if (birdName.isNotEmpty() && observationDetails.isNotEmpty()) {
            val observationEntry = ObservationEntry(birdName, observationDetails, selectedImageUri)
            // Save the observation entry to your data storage (e.g., database, file, etc.)
            // ...
            finish()
        } else {
            // Display an error message if required fields are empty
            // ...
        }
    }
    private var selectedImageUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            imgSelected.setImageURI(selectedImageUri)
        }
    }


}