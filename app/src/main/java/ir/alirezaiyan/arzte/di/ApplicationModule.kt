package ir.alirezaiyan.arzte.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ir.alirezaiyan.arzte.Arzte
import ir.alirezaiyan.arzte.BuildConfig
import ir.alirezaiyan.data.repository.DoctorsRepository
import ir.alirezaiyan.data.repository.DoctorsRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Arzte) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://vivy.com/")
            .client(createClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }


    @Provides
    @Singleton
    fun provideCache(context: Context) = context.getSharedPreferences("Arzte", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideDoctorsRepository(repository: DoctorsRepositoryImpl): DoctorsRepository = repository

}
