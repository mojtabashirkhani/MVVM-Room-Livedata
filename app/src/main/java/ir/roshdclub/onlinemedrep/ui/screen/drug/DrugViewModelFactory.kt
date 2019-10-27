package ir.roshdclub.onlinemedrep.ui.screen.drug

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DrugViewModelFactory(private val application: Application, private val subject: String?): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DrugViewModel::class.java)) {
            return DrugViewModel(application, subject) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}