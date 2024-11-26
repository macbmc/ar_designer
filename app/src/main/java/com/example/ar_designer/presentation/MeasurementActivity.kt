package com.example.ar_designer.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ar_designer.R
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.ux.ArFragment


class MeasurementActivity : AppCompatActivity() {

    private var arFragment: ArFragment? = null
    private lateinit var distanceText: TextView
    private lateinit var anchorNode1: AnchorNode
    private lateinit var anchorNode2: AnchorNode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measurement)

        arFragment = supportFragmentManager.findFragmentById(R.id.ux_fragment) as ArFragment?
        distanceText = findViewById<TextView>(R.id.distance_text)

        arFragment?.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            if (anchorNode1 == null) {
                val anchor = hitResult.createAnchor()
                anchorNode1 = AnchorNode(anchor)
                anchorNode1?.setParent(arFragment?.arSceneView?.scene)
            } else if (anchorNode2 == null) {
                val anchor = hitResult.createAnchor()
                anchorNode2 = AnchorNode(anchor)
                anchorNode2?.setParent(arFragment?.arSceneView?.scene)

                val point1 = anchorNode1?.worldPosition
                val point2 = anchorNode2?.worldPosition
                if (point1 != null && point2 != null) {
                    val distance = Vector3.subtract(point1, point2).length()
                    distanceText.text = String.format("Distance: %.2f m", distance)
                }
            }
        }
    }
}