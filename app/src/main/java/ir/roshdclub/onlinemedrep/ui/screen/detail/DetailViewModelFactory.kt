package ir.roshdclub.onlinemedrep.ui.screen.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.roshdclub.onlinemedrep.ui.screen.drug.DrugViewModel

class DetailViewModelFactory(private val application: Application, private val name: String?): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(application, name) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
