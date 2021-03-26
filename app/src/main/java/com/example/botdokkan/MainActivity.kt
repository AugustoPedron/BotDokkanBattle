package com.example.botdokkan

import android.content.Context
import android.content.Intent
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 100
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(R.layout.activity_main)

        val startServiceButton : Button = findViewById(R.id.startServiceButton)
        startServiceButton.setOnClickListener {
/*            val getImageWorkerRequest: WorkRequest =
                OneTimeWorkRequestBuilder<ImageCaptureWorker>()
                    .build()

            WorkManager
                .getInstance(applicationContext)
                .enqueue(getImageWorkerRequest)*/
            startProjection();
        }

        val stopServiceButton : Button = findViewById(R.id.stopServiceButton)
        stopServiceButton.setOnClickListener {
            stopProjection();
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                data?.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                startService(com.example.botdokkan.MainService.getStartIntent(this, resultCode, data))
            }
        }
    }

    private fun startProjection() {
        val mProjectionManager = getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
        startActivityForResult(mProjectionManager.createScreenCaptureIntent(), REQUEST_CODE)
    }

    private fun stopProjection() {
        startService(com.example.botdokkan.MainService.getStopIntent(this))
    }
}