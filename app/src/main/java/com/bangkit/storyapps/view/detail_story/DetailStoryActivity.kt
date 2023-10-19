package com.bangkit.storyapps.view.detail_story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bangkit.storyapps.data.ListStoryItem
import com.bangkit.storyapps.databinding.ActivityDetailStoryBinding
import com.bumptech.glide.Glide

class DetailStoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailStoryBinding

    companion object {
        const val data = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDetailStory()
    }

    private fun setDetailStory() {
        val data = intent.getParcelableExtra<ListStoryItem>(data)
        if (data != null) {
            binding.apply {
                Glide.with(this@DetailStoryActivity)
                    .load(data.photoUrl)
                    .into(profileImageDetail)
                tvTitleDetail.text = data.name
                tvDescriptionDetail.text = data.description
            }
            showLoading(false)
        } else {
            showToast("Data tidak valid")
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}