package cl.smu.newrickapi.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.smu.newrickapi.databinding.FragmentHomeBinding
import cl.smu.newrickapi.ui.adapter.RickMortyAdapter
import cl.smu.newrickapi.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }

    //ViewModel
    private val getCharacterViewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //RecyclerView
        val myRecycler = binding.rvHome
        val layoutManager = LinearLayoutManager(requireContext())
        myRecycler.layoutManager = layoutManager

        getCharacterViewModel.getAllCharacters()

        getCharacterViewModel.data.observe(viewLifecycleOwner) { character ->
            binding.rvHome.adapter = RickMortyAdapter(character)
        }
    }
}