package kz.tutorial.jsonplaceholdertypicode.presentation.album_photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo

class AlbumPhotosAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<PhotoViewHolder>() {

    private val photos: MutableList<Photo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = layoutInflater.inflate(R.layout.item_album_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun setData(newData: List<Photo>) {
        notifyItemRangeRemoved(0, photos.size)
        photos.clear()
        photos.addAll(newData)
        notifyItemRangeInserted(0, photos.size)
    }
}

class PhotoViewHolder(itemView: View) : ViewHolder(itemView) {
    private var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private var ivImage: ImageView = itemView.findViewById(R.id.iv_image)

    fun bind(photo: Photo) {
        tvTitle.text = photo.title

        Glide.with(itemView.context)
            .load(photo.thumbnailUrl)
            .into(ivImage)
    }
}