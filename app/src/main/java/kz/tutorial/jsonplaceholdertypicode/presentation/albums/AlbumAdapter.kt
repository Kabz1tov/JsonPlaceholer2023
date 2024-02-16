package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class AlbumAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<AlbumViewHolder>() {

    private val albums: MutableList<Album> = mutableListOf()
    var listener: ClickListener<Album>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = layoutInflater.inflate(R.layout.item_album, parent, false)

        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
        holder.itemView.setOnClickListener {
            listener?.onClick(album)
        }
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    fun setData(newData: List<Album>) {
        notifyItemRangeRemoved(0, albums.size)
        albums.clear()
        albums.addAll(newData)
        notifyItemRangeInserted(0, albums.size)
    }
}

class AlbumViewHolder(itemView: View) : ViewHolder(itemView) {
    private var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private var tvUsername: TextView = itemView.findViewById(R.id.tv_username)

    fun bind(album: Album) {
        tvTitle.text = album.title
        tvUsername.text = album.userId.toString()
    }
}