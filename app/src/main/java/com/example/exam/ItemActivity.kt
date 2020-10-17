package com.example.exam

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.modules.ItemPages
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        dialogShow()
        textView()
        backto()
    }

    fun dialogShow() {
        btnBuy.setOnClickListener { createDialog() }
    }

    fun textView() {
        val item = intent.getParcelableExtra<ItemPages>("data")
        tvProductName.text = item?.name
        tvDescription.text = item?.description
        tvPrice.text = item?.price?.toInt().toString()
        val inStock = item?.status
        if (inStock == true) {
            is_in_stock.text = getString(R.string.inStock)
        } else {
            is_in_stock.text = "Нет в наличии"
        }
        Picasso.get().load(getString(R.string.image_string))
            .into(itemInActivity)
    }

    fun createDialog() {
        val dialog = AlertDialog.Builder(this)
        val customDialog = dialog.create()
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        dialog.setView(dialogView)
        dialog.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
        dialog.setCancelable(true)
        dialog.show()
    }

    fun backto() {
        btnBack.setOnClickListener { onBackPressed() }
    }
}


///Так и не смог реализовать кастомную кнопку для диалога :(
