package com.milovanjakovljevic.bitmapmanipulation

import android.app.Activity
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : Activity() {
    lateinit var myImageView: ImageView
    lateinit var myBlankBitmap: Bitmap
    lateinit var bobBitmap: Bitmap
    lateinit var myCanvas: Canvas
    lateinit var myPaint: Paint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val widthInPixel=2000
        val heightInPixel=1000

        myBlankBitmap=Bitmap.createBitmap(widthInPixel,heightInPixel,Bitmap.Config.ARGB_8888)

        bobBitmap=BitmapFactory.decodeResource(resources,R.drawable.bob)

        myCanvas=Canvas(myBlankBitmap)

        myImageView= ImageView(this)
        myPaint=Paint()

        myCanvas.drawColor(Color.argb(255,0,0,255))

        drawRotatedBitmaps()
        drawEnlargedBitmap()
        drawShrunkenBitmap()

        myImageView.setImageBitmap(myBlankBitmap)
        setContentView(myImageView)

    }
    fun drawRotatedBitmaps() {
        var rotation = 0f
        var horizontalPosition = 350
        var verticalPosition = 25
        val matrix = Matrix()
        var rotatedBitmap: Bitmap
        rotation = 0f
        while (rotation < 360) {
            matrix.reset()
            matrix.preRotate(rotation)
            rotatedBitmap = Bitmap
                .createBitmap(bobBitmap,
                    0, 0, bobBitmap.width - 1,
                    bobBitmap.height - 1,
                    matrix, true)
            myCanvas.drawBitmap(
                rotatedBitmap,
                horizontalPosition.toFloat(),
                verticalPosition.toFloat(),
                myPaint)
            horizontalPosition += 120
            verticalPosition += 70
            rotation += 30f
        }
    }
    fun drawEnlargedBitmap() {
        bobBitmap = Bitmap
            .createScaledBitmap(bobBitmap,
                300, 400, false)
        myCanvas.drawBitmap(bobBitmap, 25f, 25f, myPaint)
    }
    fun drawShrunkenBitmap() {
        bobBitmap = Bitmap
            .createScaledBitmap(bobBitmap,
                50, 75, false)
        myCanvas.drawBitmap(bobBitmap, 250f, 25f, myPaint)
    }
}