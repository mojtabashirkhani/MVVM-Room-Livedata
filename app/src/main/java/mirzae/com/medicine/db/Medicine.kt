package mirzae.com.medicine.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicine")
data class Medicine(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "medicine_id")
    var id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = "",


    @ColumnInfo(name = "subject")
    var subject: String = "",

    @ColumnInfo(name = "content")
    var content: String = ""


)

