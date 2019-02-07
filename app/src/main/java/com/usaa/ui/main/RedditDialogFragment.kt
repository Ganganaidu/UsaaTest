package com.usaa.ui.main

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AlertDialog
import com.usass.R
import java.util.*

class RedditDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var message = arguments?.getString("message")
        
        if (message == null || message.isEmpty()) {
            message = getString(R.string.sorry_message)
        }

        return AlertDialog.Builder(Objects.requireNonNull<FragmentActivity>(activity))
            .setTitle(getString(R.string.app_name))
            .setMessage(message)
            .setPositiveButton(android.R.string.ok) { _, _ -> dismiss() }
            .create()
    }

    companion object {
        fun newInstance(message: String?): RedditDialogFragment {
            val frag = RedditDialogFragment()
            val args = Bundle()
            args.putString("message", message)
            frag.arguments = args
            return frag
        }
    }
}