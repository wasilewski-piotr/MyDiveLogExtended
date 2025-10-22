package org.itsolutions.mydivelog.app.view.certificates.create

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.presentation.certificates.create.CreateCertificateViewModel
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateRoutes.InputCertificateName
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateRoutes.SelectOrganization
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.progress.DSCircularProgressIndicator
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

@AndroidEntryPoint
class CreateCertificateActivity : MyDiveLogThemedActivity() {

    var diveOrganization by mutableStateOf<DiveOrganization?>(null)

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = title,
            type = type,
            onClick = action
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diveOrganization = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(DIVE_ORGANIZATION, DiveOrganization::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(DIVE_ORGANIZATION) as? DiveOrganization
        }
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val title = diveOrganization?.let {
            stringResource(R.string.create_certificate_for_organization_top_navigation_title, it.name)
        } ?: stringResource(R.string.create_certificate_top_navigation_title)
        val viewModel: CreateCertificateViewModel = hiltViewModel()
        var startDestination by remember { mutableStateOf<CreateCertificateRoutes?>(null) }

        fun setStartDestination() {
            startDestination = SelectOrganization
        }

        LaunchedEffect(diveOrganization) {
            topBarSettings.title(title)
            diveOrganization?.let {
                startDestination = InputCertificateName
                viewModel.updateOrganization(it)
            } ?: setStartDestination()
        }

        startDestination?.let {
            topBarSettings.CreateCertificateNavHost(
                navController = navController,
                startDestination = it,
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onFinish = {
                    setResult(RESULT_OK)
                    finish()
                }
            )
        } ?: DSCircularProgressIndicator()
    }

    companion object {
        private const val DIVE_ORGANIZATION = "dive_organization"
        fun createInstance(context: Context, diveOrganization: DiveOrganization? = null) = Intent(context, CreateCertificateActivity::class.java).apply {
            putExtra(DIVE_ORGANIZATION, diveOrganization)
        }
    }
}