package cl.smu.newrickapi.model.repository

import cl.smu.newrickapi.model.data.CharacterDetail
import cl.smu.newrickapi.model.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetCharactersRepository @Inject constructor(val apiService: ApiService) {

    suspend fun getCharacters(): List<CharacterDetail> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getCharacters()
            if (response.isSuccessful) {
                val character = response.body()?.characterDetails ?: emptyList()
                character
            } else {
                emptyList()
            }
        }
    }
}