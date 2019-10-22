package mirzae.com.medicine.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicineDao {

    @Query ("SELECT * FROM medicine WHERE  tag = (:tag)")
    fun search(tag: String): LiveData<List<Medicine>>

    @Query("SELECT * FROM medicine WHERE subject=(:subject)")
    fun getMedicines(subject: String): LiveData<List<Medicine>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicines(medicine: Medicine)

}