package com.example.swapsense.ui.Dashboard


import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.swapsense.databinding.FragmentDashboardBinding
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.widget.Toast


class DashboardFragment : Fragment() {
    private lateinit var sensorManager: SensorManager
    private lateinit var magneticSensor: Sensor
    private lateinit var proximitySensor: Sensor
    private lateinit var accelerometerSensor: Sensor
    private var _binding: FragmentDashboardBinding? = null

    // TextViews to display sensor data
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SensorManager
        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // Get sensor instances
        magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)!!
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)!!
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!!

        // Check and display if Sensors are available
        checkSensorAvailability(magneticSensor, "Magnetic Field Sensor")
        checkSensorAvailability(proximitySensor, "Proximity Sensor")
        checkSensorAvailability(accelerometerSensor, "Accelerometer")
    }

    private fun checkSensorAvailability(sensor: Sensor?, sensorName: String) {
        if (sensor == null) {
            Toast.makeText(context, "$sensorName not available", Toast.LENGTH_SHORT).show()
        }
    }

    private val sensorListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            when (event.sensor.type) {
                Sensor.TYPE_MAGNETIC_FIELD -> binding.textViewMagnetic.text = "Magnetic Field: ${event.values[0]}"
                Sensor.TYPE_PROXIMITY -> binding.textViewProximity.text = "Proximity: ${event.values[0]}"
                Sensor.TYPE_ACCELEROMETER -> binding.textViewAccelerometer.text = "Accelerometer: x=${event.values[0]}, y=${event.values[1]}, z=${event.values[2]}"
            }
        }

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // Handle sensor accuracy changes if needed
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(sensorListener, magneticSensor, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(sensorListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(sensorListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(sensorListener)
    }

    // TODO
    // checkPermission for the SENSORS


    // TODO
    // Callback for the result from requesting permissions


    // TODO
    // Declare Request codes for permissions

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

