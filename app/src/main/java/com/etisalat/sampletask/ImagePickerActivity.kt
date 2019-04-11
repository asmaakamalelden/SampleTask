package com.etisalat.sampletask

import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.sampletask.R
import kotlinx.android.synthetic.main.activity_image_picker.*
import java.util.jar.Manifest


const val REQUEST_IMAGE_CAPTURE = 1
class ImagePickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_picker)
        takeImage.setOnClickListener{(
                dispatchTakePictureIntent()
                )}
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras!!.get("data") as Bitmap
            takeImage.setImageBitmap(imageBitmap)
        }
    }
}

