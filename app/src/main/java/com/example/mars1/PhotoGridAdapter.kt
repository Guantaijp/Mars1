package com.example.mars1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mars1.databinding.GridViewItemBinding
import com.example.mars1.network.MarsPhotos

class PhotoGridAdapter : ListAdapter<MarsPhotos,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    class MarsPhotoViewHolder(private var binding:GridViewItemBinding):
    RecyclerView.ViewHolder(binding.root){
        fun bind(MarsPhotos:MarsPhotos){
            binding.photos = MarsPhotos
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
       return MarsPhotoViewHolder((GridViewItemBinding.inflate(
           LayoutInflater.from(parent.context)
       )))
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
   val marsPhotos = getItem(position)
        holder.bind(marsPhotos)
    }
}

object DiffCallback :DiffUtil.ItemCallback<MarsPhotos>() {
    override fun areItemsTheSame(oldItem: MarsPhotos, newItem: MarsPhotos): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MarsPhotos, newItem: MarsPhotos): Boolean {
        return oldItem.imgSrcUrl == newItem.imgSrcUrl
    }

}
