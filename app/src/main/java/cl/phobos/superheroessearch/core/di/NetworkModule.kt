package cl.phobos.superheroessearch.core.di

import cl.phobos.superheroessearch.heroSearch.data.network.HeroClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.cdimascio.dotenv.dotenv
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetroFit(): Retrofit {
        val dotenv = dotenv {
            directory = "/assets"
            filename = "env"
        }
        return Retrofit.Builder().baseUrl("https://superheroapi.com/api/${dotenv["TOKEN"]}/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideHeroClient(retrofit: Retrofit):HeroClient{
        return retrofit.create(HeroClient::class.java)
    }

}