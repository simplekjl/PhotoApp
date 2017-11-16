package share.dev.com.phoneapp.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import share.dev.com.phoneapp.Models.Photo
import share.dev.com.phoneapp.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        var imageView  = findViewById<ImageView>(R.id.image)
        val photo = intent.getSerializableExtra(PHOTO) as Photo?

        photo?.webformatURL.let { Glide.with(this@DetailActivity).load(photo?.webformatURL)
                .into(imageView)}

        imageView.setOnClickListener{ finish()}
    }

    companion object {
        val PHOTO = "PHOTO"
    }
}
