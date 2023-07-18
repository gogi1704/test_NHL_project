package com.example.test_nhl_project.ui.fragments

import android.content.Context.SENSOR_SERVICE
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import com.example.test_nhl_project.databinding.FragmentMoneyBinding
import com.example.test_nhl_project.viewModels.MoneyViewModel
import java.util.Random

class MoneyFragment : Fragment() {
    private lateinit var binding: FragmentMoneyBinding
    private lateinit var sensorManager: SensorManager
    private lateinit var imageView: ImageView
    private val viewModel: MoneyViewModel by viewModels()


    private var lastX = 0f
    private var lastY = 0f
    private val threshold = 0.5f // Пороговое значение для определения наклона


    private var isAnimating = false

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoneyBinding.inflate(layoutInflater, container, false)

        imageView = binding.imageMoney
        sensorManager = requireActivity().getSystemService(SENSOR_SERVICE) as SensorManager




        sensorManager.registerListener(
            object : SensorEventListener {
                override fun onSensorChanged(event: SensorEvent?) {
                    if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
                        val x = event.values[0]
                        val y = event.values[1]

                        if (Math.abs(x - lastX) > threshold || Math.abs(y - lastY) > threshold) {
                            // Наклон телефона достаточно сильный - запускаем анимацию
                            animateImageView(x, y)
                        }

                        lastX = x
                        lastY = y
                    }
                }

                override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

                }
            },
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL
        )


        viewModel.moneyCounterLiveData.observe(viewLifecycleOwner) {
            binding.moneyCounter.text = it.toString()
        }


        return binding.root
    }

    private fun animateImageView(x: Float, y: Float) {
        if (!isAnimating) {
            isAnimating = true

            val fromX = imageView.translationX
            val fromY = imageView.translationY
            val toX = fromX + x * 200
            val toY = fromY + y * 200


            val animation = TranslateAnimation(fromX, toX, fromY, toY)
            animation.duration = 500
            animation.interpolator = AccelerateInterpolator()
            animation.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}

                @RequiresApi(Build.VERSION_CODES.O)
                override fun onAnimationEnd(animation: Animation?) {
                    isAnimating = false
                    val color = Color.argb(255 , Random().nextInt(256) ,Random().nextInt(256),Random().nextInt(256) )
                    imageView.setColorFilter(color)
                    viewModel.collectMoney()
                }

                override fun onAnimationRepeat(animation: Animation?) {}
            })
            imageView.startAnimation(animation)
        }
    }



}


