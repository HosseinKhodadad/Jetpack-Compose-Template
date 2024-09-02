package com.khodadad.jetpackcomposetemplate.data.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.khodadad.jetpackcomposetemplate.data.entity.ExampleEntity

@Dao
interface ExampleDao {

    @Query("SELECT * FROM example_table")
    suspend fun getAllData(): List<ExampleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exampleEntity: List<ExampleEntity>)

    @Update
    suspend fun update(exampleEntity: ExampleEntity)

    @Delete
    suspend fun delete(exampleEntity: ExampleEntity)

}