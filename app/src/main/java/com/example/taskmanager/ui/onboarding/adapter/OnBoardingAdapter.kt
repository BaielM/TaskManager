package com.example.taskmanager.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.taskmanager.databinding.ItemOnboardingBinding
import com.example.taskmanager.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit, private val onSkip: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding(title = "Test1", description = "desc1", image = "https://img.freepik.com/free-vector/people-flying-concept-illustration_114360-3314.jpg?w=740&t=st=1692967127~exp=1692967727~hmac=a456e687e324c6ed4714914111f992515aba1c1b747878c7a903945a911875c3"),
        OnBoarding(title = "Test2", description = "desc2", image = "https://img.freepik.com/free-vector/contemplating-concept-illustration_114360-3216.jpg?w=740&t=st=1692967110~exp=1692967710~hmac=ca883a7eb4eb5ce8629217a7587aedd55cf6469c1bd9210106f8705182685ac4"),
        OnBoarding(title = "Test3", description = "desc3", image = "https://img.freepik.com/free-vector/people-flying-concept-illustration_114360-3314.jpg?w=740&t=st=1692967127~exp=1692967727~hmac=a456e687e324c6ed4714914111f992515aba1c1b747878c7a903945a911875c3"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.description
            Glide.with(binding.imgBoard).load(onBoarding.image).into(binding.imgBoard)

            binding.btnStart.isVisible = adapterPosition == list.lastIndex
            binding.skip.isVisible = adapterPosition != list.lastIndex

            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.skip.setOnClickListener {
                onSkip()
            }
        }

    }
}