package ge.nlatsabidze.taskeleven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ge.nlatsabidze.taskeleven.databinding.FragmentImageInfoBinding
import ge.nlatsabidze.taskeleven.databinding.ImageViewItemBinding


class ImageInfoFragment : Fragment() {

    private lateinit var binding: FragmentImageInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageInfoBinding.inflate(inflater, container, false)

        setResults()
        return binding.root
    }

    private fun setResults() {
        val image = arguments?.getInt("image")
        val title = arguments?.getString("title")
        val description = arguments?.getString("description")


        if (image != null) {
            binding.iv.setImageResource(image)
        }

        binding.tvTitle.text = title
        binding.tvDescription.text = description
    }
}