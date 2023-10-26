package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {typedArray.getResourceId(it, 0)}
        val imagesViewModel = ViewModelProvider(this)[ImagesViewModel::class.java]
        typedArray.recycle()

        imagesViewModel.setImages(imageArray)

        findViewById<Button>(R.id.button2).setOnClickListener(){
            (supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as ImageDisplayFragment)
                .setImages(imageArray)
        }
    }
}