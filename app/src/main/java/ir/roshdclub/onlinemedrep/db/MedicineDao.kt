package ir.roshdclub.onlinemedrep.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicineDao {

    @Query ("SELECT name, image FROM medicine WHERE tag LIKE '%' || :search|| '%' ")
    fun search(search: String?): LiveData<List<Medicine>>

    @Query("SELECT name, image FROM medicine WHERE subject = (:subject)")
    fun getMedicines(subject: String?): LiveData<List<Medicine>>

    @Query("SELECT content FROM medicine WHERE name = (:name)")
    fun getContent(name: String?): LiveData<Medicine>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicines(medicine: Medicine)

    @Query("DELETE FROM medicine")
    suspend fun deleteAll()


}