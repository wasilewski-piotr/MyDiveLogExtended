package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.results.toMessageResource
import org.itsolutions.mydivelog.app.presentation.certificates.create.CreateCertificateViewModel
import org.itsolutions.mydivelog.app.presentation.certificates.create.CreateCertificateViewModel.UiState
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateRoutes.ConfirmCertificateData
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateRoutes.CreateCertificate
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateRoutes.InputCertificateIssuer
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateRoutes.InputCertificateName
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateRoutes.SelectOrganization
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.progress.DSCircularProgressIndicator
import org.itsolutions.mydivelog.design.components.states.error.DSErrorStateFullScreen
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity.TopBarSettings

@Composable
internal fun TopBarSettings.CreateCertificateNavHost(
    navController: NavHostController,
    onBack: () -> Unit,
    onFinish: () -> Unit,
) {
    val viewModel: CreateCertificateViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    title(stringResource(R.string.create_certificate_top_navigation_title))

    if (uiState is UiState.Error && navController.currentDestination != CreateCertificate) {
        visibility(true)
        action(onFinish)
        title(stringResource(R.string.error))
        DSErrorStateFullScreen(
            subtitle = uiState.error.toMessageResource(),
            primaryButtonText = R.string.close,
            primaryButtonAction = onFinish,
        )
    }

    NavHost(navController, SelectOrganization) {
        composable<SelectOrganization> {
            action(onFinish)
            type(DSTopNavigationType.EXIT)
            CreateCertificateSelectOrganizationScreen {
                viewModel.updateOrganization(it)
                navController.navigate(InputCertificateName)
            }
        }
        composable<InputCertificateName> {
            action(onBack)
            type(DSTopNavigationType.BACK)
            if (uiState is UiState.CertificateData) {
                CreateCertificateNameInputScreen(uiState) {
                    viewModel.validateNameInputs{
                        navController.navigate(InputCertificateIssuer)
                    }
                }
            }
        }
        composable<InputCertificateIssuer> {
            action(onBack)
            type(DSTopNavigationType.BACK)
            if (uiState is UiState.CertificateData) {
                CreateCertificateIssuerInputScreen(uiState) {
                    viewModel.validateIssuerInputs {
                        navController.navigate(ConfirmCertificateData)
                    }
                }
            }
        }
        composable<ConfirmCertificateData> {
            action(onBack)
            type(DSTopNavigationType.BACK)
            if (uiState is UiState.CertificateData) {
                CreateCertificateConfirmDataScreen(
                    state = uiState,
                    createCertificate = {
                        viewModel.saveCertificateInDatabase()
                        navController.navigate(CreateCertificate)
                    },
                    cancel = onFinish
                )
            }
        }
        composable<CreateCertificate> {
            action(onFinish)
            type(DSTopNavigationType.EXIT)
            when (uiState) {
                is UiState.Error -> {
                    visibility(true)
                    title(stringResource(R.string.error))
                    DSErrorStateFullScreen(
                        subtitle = uiState.error.toMessageResource(),
                        primaryButtonText = R.string.close,
                        primaryButtonAction = onFinish,
                        secondaryButtonText = R.string.retry,
                        secondaryButtonAction = { viewModel.saveCertificateInDatabase() }
                    )
                }

                is UiState.Success -> {
                    visibility(true)
                    title(stringResource(R.string.success))
                    CreateCertificateSuccessScreen(
                        seeCertificate = { /* TODO add see cert details */ },
                        onClose = onFinish
                    )
                }

                is UiState.CreatingCertificate -> {
                    visibility(false)
                    DSCircularProgressIndicator()
                }

                else -> { /* No op */ }
            }
        }
    }
}