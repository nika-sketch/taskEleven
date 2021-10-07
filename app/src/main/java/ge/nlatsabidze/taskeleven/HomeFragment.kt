package ge.nlatsabidze.taskeleven

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.taskeleven.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var newRecyclerView : RecyclerView

    private lateinit var newArrayList: ArrayList<ImageData>

    lateinit var imageId: ArrayList<Int>
    lateinit var heading: Array<String>
    lateinit var description: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        setListeners()
        return binding.root

    }

    private fun setListeners() {

        newRecyclerView = binding.recyclerView
        newRecyclerView.layoutManager = GridLayoutManager(activity, 3)
        newRecyclerView.setHasFixedSize(true)

        imageId = mutableListOf<Int>(R.mipmap.ic_launcher, R.drawable.ic_launcher_background, R.mipmap.ic_launcher, R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.mipmap.ic_launcher_round,R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher ) as ArrayList<Int>
        heading = mutableListOf<String>("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "nineth").toTypedArray()
        description = mutableListOf<String>("i am first", "i am second", "i am third", "i am fourth", "i am fifth", "i am sixth", "i am seventh", "i am eighth", "i am nineth").toTypedArray()

        newArrayList = ArrayList<ImageData>()
        val adapter = imageViewItem(newArrayList)

        for (i in heading.indices) {
            val news = ImageData(imageId[i], heading[i], description[i])
            adapter.add(news)
        }

        val email = binding.emailField.text.toString()


        newRecyclerView.adapter = adapter
        adapter.setOnClickListener(object: imageViewItem.onItemClickListener {
            override fun onItemClick(position: Int) {
                val bundle = bundleOf("image" to imageId[position], "title" to heading[position], "description" to description[position])
                findNavController().navigate(R.id.action_homeFragment_to_imageInfoFragment, bundle)
            }
        })


    }
}