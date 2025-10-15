package org.itsolutions.mydivelog.app.domain.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable
import org.itsolutions.mydivelog.R

@Serializable
enum class DiveOrganization(
    @StringRes val longName: Int,
    @DrawableRes val logo: Int,
    val backgroundColor: Color,
) {
    AIDA(R.string.AIDA, R.drawable.aida_logo, Color.White),
//    APNEA_ACADEMY(R.string.APNEA_ACADEMY),
    CMAS(R.string.CMAS, R.drawable.cmas_logo, Color.White),
    IANTD(R.string.IANTD, R.drawable.iantd_logo, Color.White),
    IDF(R.string.IDF, R.drawable.idf_logo, Color.White),
    ITDA(R.string.ITDA, R.drawable.itda_logo, Color(0xFFFADF02)),
    MOLCHANOVS(R.string.MOLCHANOVS, R.drawable.molchanovs_logo, Color.White),
    NAUI(R.string.NAUI, R.drawable.naui_logo, Color.White),
//    PSAI(),
//    RAID(),
//    SDI(),
//    TDI(),
//    PFI(),
    SSI(R.string.SSI, R.drawable.ssi_logo, Color(0xFFE42313)),
    PADI(R.string.PADI, R.drawable.padi_logo, Color.Black),
//    GUE(R.string.GUE)
}