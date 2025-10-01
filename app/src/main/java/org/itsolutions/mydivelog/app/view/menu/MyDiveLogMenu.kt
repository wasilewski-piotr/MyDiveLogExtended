package org.itsolutions.mydivelog.app.view.menu

import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.navigation.DSBottomNavigationElement

enum class MyDiveLogMenu(val item: DSBottomNavigationElement) {
    HOME(
        DSBottomNavigationElement(
            route = "HOME",
            label = R.string.bottom_navigation_home,
            icon = R.drawable.home
        )
    ),
    CERTIFICATES(
        DSBottomNavigationElement(
            route = "CERTIFICATES",
            label = R.string.bottom_navigation_certificates,
            icon = R.drawable.badge
        )
    ),
    MY_DIVES(
        DSBottomNavigationElement(
            route = "MY_DIVES",
            label = R.string.bottom_navigation_my_dives,
            icon = R.drawable.scuba_diving
        )
    ),
    BUDDIES(
        DSBottomNavigationElement(
            route = "BUDDIES",
            label = R.string.bottom_navigation_buddies,
            icon = R.drawable.emoji_people
        )
    ),
    STATISTICS(
        DSBottomNavigationElement(
            route = "STATISTICS",
            label = R.string.bottom_navigation_statistics,
            icon = R.drawable.bar_chart
        )
    ),
}