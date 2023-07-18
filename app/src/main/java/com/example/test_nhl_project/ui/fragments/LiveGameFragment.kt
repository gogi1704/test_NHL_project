package com.example.test_nhl_project.ui.fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.test_nhl_project.databinding.FragmentLiveGameBinding
import com.example.test_nhl_project.viewModels.MoneyViewModel


class LiveGameFragment : Fragment() {
    private lateinit var binding: FragmentLiveGameBinding
    private lateinit var countDownTimer: CountDownTimer
    private var isTimerRunning = false
    private var remainingTimeInMillis: Long = 0
    private val timerDurationInMillis: Long = 3600_000

    private val moneyViewModel: MoneyViewModel by viewModels()

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
            }

            override fun onFinish() {
                isTimerRunning = false
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



        moneyViewModel.myMoneyLiveData.observe(viewLifecycleOwner) {
            binding.myMoney.text = it.toString()
        }

        return binding.root
    }


    private fun startTimer() {
        countDownTimer.start()
        isTimerRunning = true
    }


    private fun resetTimer() {
        countDownTimer.cancel()
        isTimerRunning = false
        remainingTimeInMillis = timerDurationInMillis

    }


}