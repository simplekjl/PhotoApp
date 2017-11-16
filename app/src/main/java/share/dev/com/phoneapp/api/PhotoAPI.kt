package share.dev.com.phoneapp.api

import retrofit2.Call
import retrofit2.http.GET
import share.dev.com.phoneapp.Models.PhotoList

/**
 * Created by jlcs on 11/15/17.
 */
interface PhotoAPI {

    @GET("?key=eb3700f13d46bc65950042a5f&q=nature&image_type=photo")
    fun getPhotos() : Call<PhotoList>
}