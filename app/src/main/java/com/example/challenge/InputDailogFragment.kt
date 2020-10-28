package com.example.challenge

import android.app.AlertDialog
import android.app.Dialog
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import java.util.*

class InputDailogFragment:DialogFragment() {

    private lateinit var noEditText: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val v=activity?.layoutInflater?.inflate(R.layout.the_dailoge,null)

        val nameText = v?.findViewById(R.id.editName) as EditText
        val numberText = v?.findViewById(R.id.editNum) as EditText
        val resultText = v?.findViewById(R.id.save) as CheckBox

        return AlertDialog.Builder(requireContext(),R.style.ThemeOverlay_AppCompat_Dialog_Alert)
            .setView(v)
            .setPositiveButton("Add"){ dialog, _ ->
                val s= Student(UUID.randomUUID(),nameText.text.toString(), numberText.text.toString().toInt(),resultText.isChecked)
                targetFragment?.let {
                    (it as Callbacks).onStudentAdd(s)
                }
            }.setNegativeButton("Cancel"){dialog, _ ->
                dialog.cancel()
            }.create()
    }
    interface Callbacks{
        fun onStudentAdd(student: Student)
    }


    }
