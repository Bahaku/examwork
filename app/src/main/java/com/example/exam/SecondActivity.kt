package com.example.exam

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.RvAdapter.RvAdapter
import com.example.exam.RvAdapter.listener
import com.example.exam.modules.DataPages
import com.example.exam.modules.ItemPages
import com.example.exam.modules.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_second.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecondActivity: AppCompatActivity(), listener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val adapter = RvAdapter(this)
        rvCycle.adapter = adapter

        RetrofitBuilder.getService()
            ?.getPages("1")
            ?.enqueue(object : Callback<DataPages>{
                override fun onResponse(
                    call: Call<DataPages>,
                    response: Response<DataPages>)
                {
                    if (response.isSuccessful && response.body() !=null){
                    adapter.update(response.body()?.data) }
                }

                override fun onFailure(call: Call<DataPages>, t: Throwable) {
                    Toast.makeText(applicationContext, "Нет соединения", Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun itemsClick(item: ItemPages) {
        val intent = Intent(this,ItemActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }
}
//Пагинацию не смог
