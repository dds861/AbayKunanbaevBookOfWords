package com.dd.injection

import com.dd.data.manager.AndroidResourceManager
import com.dd.data.repository.MockRepository
import com.dd.data.repository.RoomLocalStorageRepository
import com.dd.domain.manager.ResourceManager
import com.dd.domain.repository.LocalStorageRepository
import com.dd.domain.repository.Repository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

fun appDataInjection() = Kodein.Module(name = "AppDataModule") {

    bind<Repository>() with singleton { MockRepository() }

    bind<LocalStorageRepository>() with singleton { RoomLocalStorageRepository(instance()) }

    bind<ResourceManager>() with singleton { AndroidResourceManager(instance()) }
}