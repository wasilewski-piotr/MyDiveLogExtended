package org.itsolutions.mydivelog.app.view.certificates.list

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.Certificate
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.presentation.certificates.list.CertificatesListViewModel
import org.itsolutions.mydivelog.design.components.dialogs.DSAlertDialog
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

@AndroidEntryPoint
class CertificatesListActivity : MyDiveLogThemedActivity() {

    var diveOrganization by mutableStateOf<DiveOrganization?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        diveOrganization = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(DIVE_ORGANIZATION, DiveOrganization::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(DIVE_ORGANIZATION) as? DiveOrganization
        }
    }

    private fun onFinish() {
        setResult(RESULT_OK)
        finish()
    }

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = title,
            type = DSTopNavigationType.BACK,
            onClick = ::onFinish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        var showDeleteCertificateDialog by remember { mutableStateOf(false) }
        var selectedCertificate by remember { mutableStateOf<Certificate?>(null) }

        val viewModel: CertificatesListViewModel = hiltViewModel()

        topBarSettings.title(
            diveOrganization?.let {
                stringResource(R.string.certificates_screen_view_certificates_by_organization, it.name)
            } ?: stringResource(R.string.certificates_screen_view_all_certificates)
        )

        LaunchedEffect(diveOrganization) {
            viewModel.setOrganization(diveOrganization)
        }

        if (showDeleteCertificateDialog) {
            selectedCertificate?.let {
                DSAlertDialog(
                    title = stringResource(R.string.certificates_list_delete_certificate_dialog_title),
                    description = stringResource(R.string.certificates_list_delete_certificate_dialog_subtitle),
                    confirmButtonText = stringResource(R.string.delete),
                    dismissButtonText = stringResource(R.string.cancel),
                    onDismissDialog = { showDeleteCertificateDialog = false },
                    onConfirm = {
                        viewModel.deleteCertificate(it)
                        showDeleteCertificateDialog = false
                    }
                )
            } ?: {
                showDeleteCertificateDialog = false
            }
        }

        CertificatesListScreen(
            uiState = viewModel.uiState.collectAsState().value,
            onClick = { },
            onLongClick = {
                selectedCertificate = it
                showDeleteCertificateDialog = true
            },
            onRetry = { viewModel.getCertificates() },
            onRetryDelete = { viewModel.deleteCertificate(it) },
            onFinish = ::onFinish
        )
    }

    companion object {
        private const val DIVE_ORGANIZATION = "dive_organization"
        fun createInstance(context: Context, diveOrganization: DiveOrganization? = null) = Intent(context, CertificatesListActivity::class.java).apply {
            putExtra(DIVE_ORGANIZATION, diveOrganization)
        }
    }
}