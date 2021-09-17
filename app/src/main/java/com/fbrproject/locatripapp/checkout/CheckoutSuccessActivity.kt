package com.fbrproject.locatripapp.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fbrproject.locatrip.R
import com.fbrproject.locatripapp.home.HomeActivity
import kotlinx.android.synthetic.main.activity_check_out_success.*

class CheckoutSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out_success)

        btn_home.setOnClickListener {
            finishAffinity()

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}