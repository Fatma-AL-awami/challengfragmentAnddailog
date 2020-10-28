package com.example.challenge
import androidx.lifecycle.ViewModel
import java.util.*


class StudentViewModel: ViewModel() {

        val students = mutableListOf<Student>()
        init {
            for (i in 0 until 20) {
                val student = Student()
                student.studentName = "STUDENT $i"
                student.studentNumber = i

                student.studentResult =true

                students += student
            }
        }
   fun add (student:Student) {

    //students.add(student)

       val studentInput = Student()

       studentInput.studentName = student.studentName
       studentInput.studentNumber = student.studentNumber
       studentInput.studentResult = student.studentResult

       students += studentInput
}

    }
