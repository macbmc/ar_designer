package com.example.ar_designer.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ar_designer.R

class MainActivity : AppCompatActivity() {
    //private lateinit var sceneView: ARSceneView
    private lateinit var loadView: ProgressBar
    private lateinit var button: Button;

    /*private var anchorNode: AnchorNode? = null
    private var isLoading = false
        set(value) {
            field = value
            loadView.isGone = !value
        }

    private var trackingFailureReason: TrackingFailureReason? = null
        set(value) {
            if (field != value) {
                field = value
            }
        }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        /*sceneView = findViewById<ARSceneView?>(R.id.sceneView).apply {
            lifecycle = this@MainActivity.lifecycle
            planeRenderer.isEnabled = true
            configureSession { session, config ->
                config.depthMode = when (session.isDepthModeSupported(Config.DepthMode.AUTOMATIC)) {
                    true -> Config.DepthMode.AUTOMATIC
                    else -> Config.DepthMode.DISABLED
                }
                config.instantPlacementMode = Config.InstantPlacementMode.DISABLED
                config.lightEstimationMode = Config.LightEstimationMode.ENVIRONMENTAL_HDR
            }
            onSessionUpdated = { _, frame ->
                if (anchorNode == null) {
                    frame.getUpdatedPlanes()
                        .firstOrNull { it.type == Plane.Type.HORIZONTAL_UPWARD_FACING }
                        ?.let { plane ->
                            addAnchorNode(plane.createAnchor(plane.centerPose))
                        }
                }
            }
            onTrackingFailureChanged = { reason ->
                this@MainActivity.trackingFailureReason = reason
            }
        }*/
        loadView = findViewById(R.id.loadingView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, ModelActivity::class.java)
            startActivity(intent)
            finish()
            /*button.setEnabled(false)
            loadView.visibility = View.VISIBLE
            val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
            sceneViewerIntent.data =
                Uri.parse("https://modelviewer.dev/shared-assets/models/Astronaut.glb")
            sceneViewerIntent.setPackage("com.google.android.googlequicksearchbox")
            sceneViewerIntent.putExtra("mode", "ar_preferred")

            if (sceneViewerIntent.resolveActivity(packageManager) != null) {
                startActivity(sceneViewerIntent)
            } else {
// Handle the fallback scenario
                Toast.makeText(
                    this,
                    "No application available to view the model",
                    Toast.LENGTH_SHORT
                ).show()
            }*/


        }


    }

    /*private fun addAnchorNode(anchor: Anchor) {
        sceneView.addChildNode(
            AnchorNode(sceneView.engine, anchor)
                .apply {
                    isEditable = true
                    lifecycleScope.launch {
                        isLoading = true
                        buildModelNode()?.let { addChildNode(it) }
    //                        buildViewNode()?.let { addChildNode(it) }
                        isLoading = false
                    }
                    anchorNode = this
                }
        )
    }*/

    /*private suspend fun buildModelNode(): ModelNode? {
        sceneView.modelLoader.loadModelInstance(
            "https://sceneview.github.io/assets/models/DamagedHelmet.glb"
        )?.let { modelInstance ->
            return ModelNode(
                modelInstance = modelInstance,
                // Scale to fit in a 0.5 meters cube
                scaleToUnits = 0.5f,
                // Bottom origin instead of center so the model base is on floor
                centerOrigin = Position(y = -0.5f)
            ).apply {
                isEditable = true
            }
        }
        return null
    }*/

}