/*
package com.example.botdokkan

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Environment
import android.view.View
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.botdokkan.databinding.ActivityMainBinding
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import kotlinx.android.synthetic.main.activity_main.*

class ImageCaptureWorker (appContext: Context, workerParams: WorkerParameters,
    private val binding: ActivityMainBinding):
    Worker(appContext, workerParams) {

    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        //uploadImages()
        println("ciao")

        val v: View = binding.root
        val b: Bitmap? = getBitmapFromView(v)
        val extr: String = applicationContext.getExternalFilesDirs(Environment.DIRECTORY_PICTURES).toString()
        val myPath = File(extr, "prova" + ".png")
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(myPath)
            b?.compress(Bitmap.CompressFormat.PNG, 100, fos)
            fos.flush()
            fos.close()
        } catch (e: FileNotFoundException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: Exception) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun getBitmapFromView(view: View): Bitmap? {
        var bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        var canvas = Canvas(bitmap)
        view.draw(canvas)
        return bitmap
    }
}*/
