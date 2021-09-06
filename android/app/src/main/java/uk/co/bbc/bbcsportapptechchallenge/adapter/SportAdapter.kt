package uk.co.bbc.bbcsportapptechchallenge.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uk.co.bbc.bbcsportapptechchallenge.presentation.SportViewModel
import uk.co.bbc.bbcsportapptechchallenge.ui.SportLayout

class SportAdapter(
    private val sportList: List<SportViewModel>,
) : ListAdapter<SportViewModel, SportAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SportLayout(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sport: SportViewModel = sportList[position]
        holder.component.render(sport)
    }

    override fun getItemCount() = sportList.size

    class ViewHolder(val component: SportLayout) : RecyclerView.ViewHolder(component)

    companion object DiffCallback : DiffUtil.ItemCallback<SportViewModel>() {
        override fun areItemsTheSame(oldItem: SportViewModel, newItem: SportViewModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: SportViewModel, newItem: SportViewModel): Boolean {
            return oldItem.data == newItem.data
        }
    }
}