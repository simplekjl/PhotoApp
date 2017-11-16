package share.dev.com.phoneapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import share.dev.com.phoneapp.Models.Photo
import share.dev.com.phoneapp.Models.PhotoList
import share.dev.com.phoneapp.adapters.PhotoAdapter
import share.dev.com.phoneapp.api.PhotoRetriever

class MainActivity : AppCompatActivity(), View.OnClickListener {


    //nullable variables because we do not have a value for them yet
    var photos : List<Photo>? = null
    var adapter : PhotoAdapter? = null
    //late init allows you to declare the variable in here, and initialized in the onCreate method
    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        recyclerView = findViewById(R.id.my_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        var retriever = PhotoRetriever()

        var callback = object : Callback<PhotoList>{
            override fun onFailure(call: Call<PhotoList>?, t: Throwable?) {
                Log.e("ERROR","Something went wrong")
            }

            override fun onResponse(call: Call<PhotoList>?, response: Response<PhotoList>?) {
                response?.isSuccessful.let {
                    this@MainActivity.photos = response?.body()?.hits
                    adapter = PhotoAdapter(this@MainActivity.photos!!,this@MainActivity)
                    recyclerView.adapter = adapter
                }

            }
        }

        retriever.getPhotos(callback)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onClick(p0: View?) {

    }
}
