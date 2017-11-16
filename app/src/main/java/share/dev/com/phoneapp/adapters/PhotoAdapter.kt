package share.dev.com.phoneapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import share.dev.com.phoneapp.Models.Photo
import share.dev.com.phoneapp.R

/**
 * Created by jlcs on 11/15/17.
 */
class PhotoAdapter(var photos: List<Photo>,
                   var clickListener: View.OnClickListener) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    fun getPhoto(adapterPosition : Int) : Photo {

        return photos[adapterPosition]
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.likes?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        if (photo.previewURL.isNotEmpty()){
            Glide.with(holder?.tags?.context).load(photo.previewURL)
                    .into(holder?.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_item,parent,false))
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder
    //constructor for ViewHolder
    (itemView) {
        //variables on the class
        var tags : TextView
        var likes : TextView
        var favorites : TextView
        var image : ImageView

        init {
            if (clickListener != null){
                itemView.setOnClickListener(clickListener)
            }

            itemView.tag =this
            tags = itemView.findViewById<TextView>(R.id.tags)
            likes = itemView.findViewById<TextView>(R.id.likes)
            favorites = itemView.findViewById<TextView>(R.id.favorites)
            image = itemView.findViewById<ImageView>(R.id.image)
        }
    }

}