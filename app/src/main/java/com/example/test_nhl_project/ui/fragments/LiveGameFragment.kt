package com.example.test_nhl_project.ui.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test_nhl_project.databinding.FragmentLiveGameBinding


class LiveGameFragment : Fragment() {
    private lateinit var binding: FragmentLiveGameBinding
    private lateinit var countDownTimer: CountDownTimer
    private var isTimerRunning = false
    private var remainingTimeInMillis: Long = 0
    private val timerDurationInMillis: Long = 3600_000 // Продолжительность таймера в миллисекундах

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLiveGameBinding.inflate(layoutInflater, container, false)

        countDownTimer = object : CountDownTimer(timerDurationInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTimeInMillis = millisUntilFinished
                binding.textMin.text = (remainingTimeInMillis / 1000 / 60).toString()
                binding.textSec.text = (remainingTimeInMillis / 1000 % 60).toString()
                updateUI()
            }

            override fun onFinish() {
                isTimerRunning = false
                // Действия после завершения таймера
                // Например, выполнение определенных действий или отображение сообщения
            }
        }

        with(binding) {
            buttonFirstPlus.setOnClickListener {
                val num = textFirstCounter.text.toString().toInt() + 1
                textFirstCounter.text = num.toString()
                toggleButtonFirst.clearChecked()
            }
            buttonFirstMinus.setOnClickListener {
                val num = textFirstCounter.text.toString().toInt() - 1
                textFirstCounter.text = num.toString()
                toggleButtonFirst.clearChecked()
            }

            buttonSecondPlus.setOnClickListener {
                val num = textSecondCounter.text.toString().toInt() + 1
                textSecondCounter.text = num.toString()
                toggleButtonSecond.clearChecked()
            }
            buttonSecondMinus.setOnClickListener {
                val num = textSecondCounter.text.toString().toInt() - 1
                textSecondCounter.text = num.toString()
                toggleButtonSecond.clearChecked()
            }

            buttonStart.setOnClickListener {
                startTimer()
                toggleButtonStart.clearChecked()
            }

            buttonReset.setOnClickListener {
                resetTimer()
                textFirstCounter.text = "0"
                textSecondCounter.text = "0"
                textMin.text = "60"
                textSec.text = "00"
                toggleButtonStart.clearChecked()
            }


        }



        return binding.root
    }


    private fun startTimer() {
        countDownTimer.start()
        isTimerRunning = true
    }

    private fun pauseTimer() {
        countDownTimer.cancel()
        isTimerRunning = false
    }

    private fun resetTimer() {
        countDownTimer.cancel()
        isTimerRunning = false
        remainingTimeInMillis = timerDurationInMillis
        updateUI()
    }

    private fun updateUI() {
        // Обновите ваш интерфейс (например, TextView) для отображения оставшегося времени
    }


}