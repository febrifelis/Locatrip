package com.fbrproject.locatripapp.home.tiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fbrproject.locatrip.R
import com.fbrproject.locatripapp.model.Checkout
import com.fbrproject.locatripapp.model.Trip
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_tiket.*
import kotlinx.android.synthetic.main.activity_tiket.tv_kapasitas
import kotlinx.android.synthetic.main.activity_tiket.tv_rate

class TiketActivity : AppCompatActivity() {

    private var dataList =ArrayList<Checkout>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiket)

        var data = intent.getParcelableExtra<Trip>("data")

        tv_title.text = data?.judul
        tv_kapasitas.text = data?.kapasitas
        tv_rate.text = data?.rating

        Glide.with(this)
            .load(data?.poster)
            .into(iv_poster_image)

        rc_checkout.layoutManager = LinearLayoutManager(this)
        dataList.add(Checkout("C1",""))
        dataList.add(Checkout("C2",""))

        rc_checkout.adapter = TiketAdapter(dataList) {

        }
    }
}