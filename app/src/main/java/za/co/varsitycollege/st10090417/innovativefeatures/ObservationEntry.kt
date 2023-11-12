package za.co.varsitycollege.st10090417.innovativefeatures

import android.net.Uri

data class  ObservationEntry(
    val birdName: String,
    val observationDetails: String,
    val imageUri: Uri?
    )