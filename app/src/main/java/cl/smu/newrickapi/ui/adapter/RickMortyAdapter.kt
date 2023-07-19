package cl.smu.newrickapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.smu.newrickapi.databinding.ItemApiBinding
import cl.smu.newrickapi.model.data.CharacterDetail

class RickMortyAdapter(private val dataSet: List<CharacterDetail>) :
    RecyclerView.Adapter<RickMortyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        val binding = ItemApiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RickMortyViewHolder(binding)
    }


    override fun onBindViewHolder(viewholder: RickMortyViewHolder, position: Int) {
        viewholder.bind(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size
}