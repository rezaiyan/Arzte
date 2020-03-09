package ir.alirezaiyan.arzte.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import ir.alirezaiyan.arzte.R
import ir.alirezaiyan.base.component.DoctorListComponent
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val mainContainer = onView(withId(R.id.mainContainer))
        Thread.sleep(5000)
        mainContainer.check(matches(isDisplayed()))

        val relativeLayout = onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.componentList), childAtPosition(
                            withClassName(`is`(DoctorListComponent::class.java.canonicalName)), 1
                        )
                    ), 2
                ),
                isDisplayed()
            )
        )
        relativeLayout.perform(click())

        Thread.sleep(2000)
        val detailContainer = onView(withId(R.id.detailContainer))
        detailContainer.check(matches(isDisplayed()))

        pressBack()

        Thread.sleep(2000)

        val recentContainer = onView(withId(R.id.recentContainer))
        recentContainer.check(matches(isDisplayed()))

        onView(
            allOf(
                childAtPosition(
                    allOf(
                        withId(R.id.recentContainer), childAtPosition(
                            withClassName(`is`(DoctorListComponent::class.java.canonicalName)), 1
                        )
                    ), 0
                ),
                isDisplayed()
            )
        )

    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
