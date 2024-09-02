package com.khodadad.jetpackcomposetemplate.data.repository

import com.khodadad.jetpackcomposetemplate.data.dao.ExampleDao
import com.khodadad.jetpackcomposetemplate.data.entity.ExampleEntity
import com.khodadad.jetpackcomposetemplate.data.model.ExampleModel
import com.khodadad.jetpackcomposetemplate.data.model.Resource
import com.khodadad.jetpackcomposetemplate.data.remote.AppApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExampleRepository @Inject constructor(
    private val appApi: AppApi,
    private val exampleDao: ExampleDao
) {

    suspend fun fetchData(): Resource<List<ExampleModel>> {
        return try {
            // نتیجه را از سرویس دریافت کنید
            val response = appApi.getExampleResult()

            if (response.isSuccessful) {
                val data = response.body()
                if (data != null) {
                    // تبدیل داده‌های دریافتی به لیست از Entity
                    val entityList = data.map { exampleModel ->
                        ExampleEntity(
                            title = exampleModel.title,
                            description = exampleModel.description
                        )
                    }
                    // ذخیره داده‌ها در پایگاه داده
                    exampleDao.insert(entityList)
                    // برگرداندن نتیجه موفقیت‌آمیز همراه با داده‌ها
                    Resource.Success(data)
                } else {
                    // برگشت خطا در صورتی که بدنه پاسخ خالی باشد
                    Resource.Error("بدنه پاسخ خالی است")
                }
            } else {
                // برگشت خطا در صورتی که پاسخ ناموفق باشد
                Resource.Error("خطا در دریافت داده: ${response.code()}")
            }
        } catch (e: Exception) {
            // برگشت خطا در صورتی که خطایی پیش بیاید
            Resource.Error(e.message ?: "خطا در دریافت داده")
        }
    }

    suspend fun updateData(exampleModel: ExampleModel): Resource<Unit> {
        return try {
            // تبدیل مدل به Entity
            val exampleEntity =
                ExampleEntity(title = exampleModel.title, description = exampleModel.description)
            // به‌روزرسانی داده در پایگاه داده
            exampleDao.update(exampleEntity)
            // برگرداندن نتیجه موفقیت‌آمیز بدون داده
            Resource.Success(Unit)
        } catch (e: Exception) {
            // برگشت خطا در صورتی که خطایی پیش بیاید
            Resource.Error(e.message ?: "خطا در به‌روزرسانی داده")
        }
    }

    suspend fun deleteData(exampleModel: ExampleModel): Resource<Unit> {
        return try {
            // تبدیل مدل به Entity
            val exampleEntity =
                ExampleEntity(title = exampleModel.title, description = exampleModel.description)
            // حذف داده از پایگاه داده
            exampleDao.delete(exampleEntity)
            // برگرداندن نتیجه موفقیت‌آمیز بدون داده
            Resource.Success(Unit)
        } catch (e: Exception) {
            // برگشت خطا در صورتی که خطایی پیش بیاید
            Resource.Error(e.message ?: "خطا در حذف داده")
        }
    }

}