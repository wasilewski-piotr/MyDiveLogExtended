package org.itsolutions.mydivelog.app.configuration

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.itsolutions.mydivelog.app.data.local.repository.CertificateRepositoryImpl
import org.itsolutions.mydivelog.app.domain.repository.CertificateRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCertificateRepository(
        impl: CertificateRepositoryImpl
    ): CertificateRepository
}