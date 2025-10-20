package org.itsolutions.mydivelog.design.app.inputs.text

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
import org.itsolutions.mydivelog.design.components.inputs.DSTextInput
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSTextInputPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Text Input",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val scrollState = rememberScrollState()
        val field = ValidationField("", Rules.notEmpty())
        val errorField = ValidationField("", Rules.notEmpty())
        errorField.set(ValidationError.Required)

        Column(
            modifier = Modifier.Companion.verticalScroll(scrollState).verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xl)
        ) {
            DSSection("DSTextInput") {
                DSTextInput(
                    field = field,
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSTextInput | With Label") {
                DSTextInput(
                    field = field,
                    label = "Text Input",
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSTextInput | Leading Icon") {
                DSTextInput(
                    field = field,
                    label = "Text Input",
                    placeholder = "Placeholder",
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSTextInput | Trailing Icon") {
                DSTextInput(
                    field = field,
                    label = "Text Input",
                    placeholder = "Placeholder",
                    trailingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSTextInput | Both Icons") {
                DSTextInput(
                    field = field,
                    label = "Text Input",
                    placeholder = "Placeholder",
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    },
                    trailingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }

            DSSection("DSTextInput | Error") {
                DSTextInput(
                    field = errorField,
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSTextInput | Error With Label") {
                DSTextInput(
                    field = errorField,
                    label = "Text Input",
                    placeholder = "Placeholder"
                )
            }
            DSSection("DSTextInput | Error Leading Icon") {
                DSTextInput(
                    field = errorField,
                    label = "Text Input",
                    placeholder = "Placeholder",
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSTextInput | Error Trailing Icon") {
                DSTextInput(
                    field = errorField,
                    label = "Text Input",
                    placeholder = "Placeholder",
                    trailingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
            DSSection("DSTextInput | Error Both Icons") {
                DSTextInput(
                    field = errorField,
                    label = "Text Input",
                    placeholder = "Placeholder",
                    leadingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    },
                    trailingIcon = {
                        Icon(painterResource(R.drawable.bar_chart), null)
                    }
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) =
            Intent(context, DSTextInputPreviewActivity::class.java)
    }

}