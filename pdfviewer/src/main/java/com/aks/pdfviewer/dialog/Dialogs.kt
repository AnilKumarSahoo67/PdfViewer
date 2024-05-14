package com.aks.pdfviewer.dialog

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.aks.pdfviewer.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object Dialogs {

    private var loadingDialog: AlertDialog? = null


    fun messageDialog(
        status: Boolean,
        context: Activity,
        title: String,
        message: String,
        isCancellable: Boolean,
        positiveButtonText: String?,
        callBack: (Boolean) -> Unit
    ) {
        context.runOnUiThread {

            if (status) {
                if (loadingDialog != null) {
                    if (loadingDialog?.isShowing == true) {
                        loadingDialog?.dismiss()
                    }
                }
                val popUp = MaterialAlertDialogBuilder(context)
                val view = context.layoutInflater.inflate(R.layout.pop_up_message_dialog, null)
                popUp.setView(view)
                val contentImage: ImageView = view.findViewById(R.id.warningImage)
                val tittleHeading: TextView = view.findViewById(R.id.tittle)
                val description: TextView = view.findViewById(R.id.description)
                val closeDialog: ImageButton = view.findViewById(R.id.closeDialog)
                val okButton: Button = view.findViewById(R.id.btnOk)
//                contentImage.setImageResource(image)
                tittleHeading.text = title
                description.text = message
                okButton.text = positiveButtonText?:"OK"
                loadingDialog = popUp.create()
                loadingDialog?.setCancelable(isCancellable)
                loadingDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                loadingDialog?.show()
                closeDialog.setOnClickListener {
                    loadingDialog?.dismiss()
                }
                okButton.setOnClickListener {
                    loadingDialog?.dismiss()
                    callBack(true)
                }


            } else {
                if (loadingDialog != null) {
                    if (loadingDialog?.isShowing == true) {
                        loadingDialog?.dismiss()
                    }
                }
            }
        }

    }


    fun showToastMessage(activity: Activity, message: String) {
        activity.runOnUiThread(Runnable {
            Toast.makeText(
                activity,
                message,
                Toast.LENGTH_SHORT
            ).show()
        })
    }

}