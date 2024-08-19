package com.sample.app

import android.content.Context
import androidx.appcompat.app.AlertDialog

class Utils {

    fun showAlertDialog(context: Context, title: String, description: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(description)
        // Positive button
        builder.setNegativeButton("No") { dialog, _ ->
            // Handle positive button click
            dialog.dismiss()
        }

        // Positive button
        builder.setPositiveButton("Yes") { dialog, _ ->
            // Handle positive button click
            dialog.dismiss()
        }
        // Create and show the dialog
        val dialog = builder.create()
        dialog.show()
    }

}