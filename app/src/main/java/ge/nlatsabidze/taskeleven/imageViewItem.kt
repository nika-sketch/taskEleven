package ge.nlatsabidze.taskeleven

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.taskeleven.databinding.ImageViewItemBinding

class imageViewItem(private val imageList: ArrayList<ImageData>): RecyclerView.Adapter<imageViewItem.ImageViewHolder>() {

    private lateinit var cliclListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnClickListener(listener: onItemClickListener) {
        cliclListener = listener
    }

    inner class ImageViewHolder(binding: ImageViewItemBinding, listener: onItemClickListener):RecyclerView.ViewHolder(binding.root) {
        val image = binding.imageView
        val text = binding.tv

        init {
            itemView.setOnClickListener {
                listener.onItemClick(absoluteAdapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ImageViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding, cliclListener)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.image.setImageResource(currentItem.titleImage)
        holder.text.text = currentItem.heading
    }

    override fun getItemCount() = imageList.size

    fun add(data: ImageData) {
        imageList.add(data)
        notifyItemInserted(imageList.size - 1)
    }

    fun remove(data: ImageData) {
        imageList.remove(data)
        notifyDataSetChanged()
    }
}