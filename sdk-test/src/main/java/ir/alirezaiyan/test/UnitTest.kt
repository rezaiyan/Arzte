package ir.alirezaiyan.test

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

/**
 * Base class for Unit tests. Inherit from it to create test cases which DO NOT contain android
 * framework dependencies or components.
 *
 */
@RunWith(MockitoJUnitRunner::class)
abstract class UnitTest {

    @Rule
    @JvmField
    val injectMocks = InjectMocksRule.create(this)
}
