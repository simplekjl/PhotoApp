package share.dev.com.phoneapp.Models

import java.io.Serializable

/**
 * Created by jlcs on 11/15/17.
 */
data class Photo(val  id : String ,
                 val  likes : Int ,
                 val  favorites : Int,
                 val  tags : String,
                 val  previewURL : String,
                 val  webformatURL : String
                 ) : Serializable {

}