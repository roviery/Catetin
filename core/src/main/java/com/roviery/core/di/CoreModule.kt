package com.roviery.core.di

import androidx.room.Room
import com.roviery.core.data.source.local.LocalDataSource
import com.roviery.core.data.source.local.room.CatetinDatabase
import com.roviery.core.data.source.repository.DeadlineRepository
import com.roviery.core.domain.repository.IDeadlineRepository
import com.roviery.core.utils.AppExecutors
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module{
    factory { get<CatetinDatabase>().catetinDao()}
    single {
        Room.databaseBuilder(
            androidContext(),
            CatetinDatabase::class.java,
            "Catetin.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    factory { AppExecutors() }
    single<IDeadlineRepository> {
        DeadlineRepository(
            get(),
            get()
        )
    }
}