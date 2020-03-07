package ir.alirezaiyan.arzte.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import ir.alirezaiyan.base.component.DoctorListComponent
import kotlinx.android.synthetic.main.fragment_main.*
import org.junit.Assert.assertSame
import org.junit.Test
import org.junit.runner.RunWith


/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/7/2020 8:26 PM.
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class MainFragmentTest {

    lateinit var mainFragment: MainFragment
    @Test
    fun viewContainerTest() {

        FragmentScenario.launch(MainFragment::class.java).onFragment {
            mainFragment = it
        }

        val mainContainer = mainFragment.mainContainer

        assertSame(mainContainer.childCount, 1)
        assertSame(mainContainer.getChildAt(0).javaClass, DoctorListComponent::class.java)
    }
}