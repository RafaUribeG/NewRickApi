package cl.smu.newrickapi.model.network

import cl.smu.newrickapi.model.data.Character
import cl.smu.newrickapi.util.Constants
import retrofit2.Response
import retrofit2.http.GET




interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getCharacters() : Response<Character>
}