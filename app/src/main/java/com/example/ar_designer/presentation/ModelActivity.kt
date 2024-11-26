package com.example.ar_designer.presentation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.ar_designer.R
import com.google.ar.core.Anchor
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode


class ModelActivity : AppCompatActivity() {
    private lateinit var arFragment: ArFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_model)

        arFragment = supportFragmentManager.findFragmentById(R.id.ux_fragment) as ArFragment

        arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
            Log.d("ARTOUCH","CALLED")
            val anchor = hitResult.createAnchor()
            placeObject(arFragment, anchor, Uri.parse("https://modelviewer.dev/shared-assets/models/Astronaut.glb"))
        }
    }

    private fun placeObject(arFragment: ArFragment, anchor: Anchor, modelUri: Uri) {
        ModelRenderable.builder()
            .setSource(arFragment.context, modelUri)
            .build()
            .thenAccept { renderable ->
                val anchorNode = AnchorNode(anchor)
                anchorNode.setParent(arFragment.arSceneView.scene)

                val node = TransformableNode(arFragment.transformationSystem)
                node.setParent(anchorNode)
                node.renderable = renderable
                node.select()
            }
            .exceptionally { throwable ->
// Handle the error
                null
            }
    }
}