package com.trainingdeveloperpro.androidk001.lesson7linh

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_create_student_card.*

class CreateStudentCardActivity : AppCompatActivity() {
    private val TAG = CreateStudentCardActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_student_card)
    }

    fun createStudent(view: View) {
        val returnIntent = Intent()
        returnIntent.putExtra(EXTRA_STUDENT_NAME, edit_text_fragment_create_student_card_name.text.toString())
        returnIntent.putExtra(EXTRA_STUDENT_AGE, edit_text_fragment_create_student_card_age.text.toString())
        returnIntent.putExtra(EXTRA_STUDENT_PHONE, edit_text_fragment_create_student_card_phone.text.toString())

        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }
}
