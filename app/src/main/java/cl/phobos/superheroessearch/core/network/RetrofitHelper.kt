package cl.phobos.superheroessearch.core.network

import io.github.cdimascio.dotenv.dotenv
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    fun getRetrofit(): Retrofit {
        val dotenv = dotenv {
            directory = "/assets"
            filename = "env"
        }
        return Retrofit.Builder().baseUrl("https://superheroapi.com/api/${dotenv["TOKEN"]}/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}