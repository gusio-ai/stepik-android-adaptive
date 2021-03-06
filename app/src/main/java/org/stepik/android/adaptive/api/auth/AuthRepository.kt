package org.stepik.android.adaptive.api.auth

import io.reactivex.Completable
import io.reactivex.Single
import org.stepik.android.adaptive.data.model.RegistrationUser

interface AuthRepository {

    fun authWithLoginPassword(login: String, password: String): Single<OAuthResponse>
    fun authWithNativeCode(code: String, type: SocialManager.SocialType): Single<OAuthResponse>

    fun authWithCode(code: String): Single<OAuthResponse>

    fun createAccount(credentials: RegistrationUser): Completable

}