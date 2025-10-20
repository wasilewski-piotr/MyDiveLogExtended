package org.itsolutions.mydivelog.design.app.inputs.date

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.validation.Rules
import org.itsolutions.mydivelog.app.domain.validation.ValidationError
import org.itsolutions.mydivelog.app.domain.validation.ValidationField
import org.itsolutions.mydivelog.design.components.inputs.DSDateInput
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding
import java.time.LocalDate

internal class DSDateInputPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Date Input",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val scrollState = rememberScrollState()
        val field = ValidationField<LocalDate?>(null, Rules.required())
        val errorField = ValidationField<LocalDate?>(null, Rules.required())
        errorField.set(ValidationError.Required)

        Column(
            modifier = Modifier.Companion.verticalScroll(scrollState).verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xl)
        ) {
            DSSection("DSDateInput") {
                DSDateInput(
                    field = field,
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSDateInput | With Label") {
                DSDateInput(
                    field = field,
                    label = "Date Input",
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSDateInput | With Custom Trailing Icon") {
                DSDateInput(
                    field = field,
                    label = "Date Input",
                    placeholder = "Placeholder",
                    trailingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSDateInput | With Only Leading Icon") {
                DSDateInput(
                    field = field,
                    label = "Date Input",
                    placeholder = "Placeholder",
                    trailingIcon = { },
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSDateInput | With Both Icons") {
                DSDateInput(
                    field = field,
                    label = "Date Input",
                    placeholder = "Placeholder",
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSDateInput") {
                DSDateInput(
                    field = errorField,
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSDateInput | With Label") {
                DSDateInput(
                    field = errorField,
                    label = "Date Input",
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSDateInput | With Custom Trailing Icon") {
                DSDateInput(
                    field = errorField,
                    label = "Date Input",
                    placeholder = "Placeholder",
                    trailingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSDateInput | With Single Leading Icon") {
                DSDateInput(
                    field = errorField,
                    label = "Date Input",
                    placeholder = "Placeholder",
                    trailingIcon = { },
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSDateInput | With Both Icons") {
                DSDateInput(
                    field = errorField,
                    label = "Date Input",
                    placeholder = "Placeholder",
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) =
            Intent(context, DSDateInputPreviewActivity::class.java)
    }
}