package com.fbrproject.locatrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.fbrproject.locatripapp.checkout.PilihBangkuActivity
import com.fbrproject.locatripapp.home.dashboard.PenumpangAdapter
import com.fbrproject.locatripapp.model.Penumpang
import com.fbrproject.locatripapp.model.Trip
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var mDatabase : DatabaseReference
    private var dataList = ArrayList<Penumpang>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Trip>("data")

        mDatabase = FirebaseDatabase.getInstance().getReference("Trip")
            .child(data?.judul.toString())
            .child("penumpang")

        tv_kursi.text = data?.judul
        tv_kapasitas.text = data?.kapasitas
        tv_desc.text = data?.desc
        tv_rate.text = data?.rating

        Glide.with(this)
            .load(data?.poster)
            .into(iv_poster)

        rv_penumpang.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        getData()

        btn_pilih_bangku.setOnClickListener {
            var intent = Intent (this@DetailActivity, PilihBangkuActivity::class.java).putExtra("data",data)
            startActivity(intent)
        }
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                dataList.clear()

                for (getdataSnapshot in p0.children){
                    var Trip = getdataSnapshot.getValue(Penumpang::class.java)
                    dataList.add(Trip!!)
                }

                rv_penumpang.adapter = PenumpangAdapter(dataList){}

            }

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(this@DetailActivity, ""+p0.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}