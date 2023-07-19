package cl.smu.newrickapi.domain

import cl.smu.newrickapi.model.repository.GetCharactersRepository
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(private val repository: GetCharactersRepository) {

    suspend operator fun invoke() = repository.getCharacters()
}