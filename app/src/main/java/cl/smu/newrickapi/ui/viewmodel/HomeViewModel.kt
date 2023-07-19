package cl.smu.newrickapi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.smu.newrickapi.domain.GetCharactersUseCase
import cl.smu.newrickapi.model.data.CharacterDetail
import cl.smu.newrickapi.model.repository.GetCharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repo: GetCharactersRepository) : ViewModel() {

    val data = MutableLiveData<List<CharacterDetail>>()

    fun getAllCharacters() {
        viewModelScope.launch {
            val dataFromRepo = repo.getCharacters()
            if (dataFromRepo.isNotEmpty()){
                data.postValue(dataFromRepo)
            }
        }
    }
}