package com.nabilafirdha.projekbaru

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailPemesananActivity : AppCompatActivity() {
    private var tv_totalPemesanan: TextView? = null
    private var bt_pesanLagi: Button? = null
    private var bt_selesai: Button? = null
    private var teksTotal: String? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detil_pemesanan)
        panggilView()
        tangkapDataIntent()
        actionView()
    }

    private fun actionView() {
        bt_pesanLagi!!.setOnClickListener { // fungsi untuk kembali seperti menekan tombol back pada smartphone
            onBackPressed()
        }
        bt_selesai!!.setOnClickListener { // siapkan intent dari detail pemesanan ke main
            val keMainActivity =
                Intent(this@DetailPemesananActivity, MainActivity::class.java)

            // supaya setelah sampai di main activity dan di tekan tombol back tidak kembali ke detail pemesanan
            keMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            // pindah ke main
            startActivity(keMainActivity)
        }
    }

    private fun tangkapDataIntent() {
        teksTotal = getIntent().getExtras()?.getString("totalPemesanan")
        tv_totalPemesanan!!.text = "Rp. $teksTotal,-"
    }

    private fun panggilView() {
        tv_totalPemesanan = findViewById(R.id.tv_totalPemesanan) as TextView?
        bt_pesanLagi = findViewById(R.id.bt_pesanLagi) as Button?
        bt_selesai = findViewById(R.id.bt_keluar) as Button?
    }
}