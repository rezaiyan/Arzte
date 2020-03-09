package ir.alirezaiyan.domain.ext

import ir.alirezaiyan.base.ext.Either
import ir.alirezaiyan.base.ext.Failure
import ir.alirezaiyan.test.UnitTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.amshove.kluent.shouldEqual
import org.junit.After
import org.junit.Before
import org.junit.Test


/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 4:23 PM.
 */
@ExperimentalCoroutinesApi
class UseCaseTest : UnitTest() {

    private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()

    private val TYPE_TEST = "Test"
    private val TYPE_PARAM = "ParamTest"

    private val useCase = MyUseCase()

    private val actualTestResult = Either.Right(MyType(TYPE_TEST))

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun usecaseTypeTest() = runBlocking {
        val params = MyParams(TYPE_PARAM)
        val result = useCase.run(params)

        result.shouldEqual(actualTestResult)
    }

    @Test
    fun usecaseResultTest() {
        var result: Either<Failure, MyType>? = null
        val params = MyParams("TestParam")

        val onResult = { myResult: Either<Failure, MyType>
            ->
            result = myResult
        }

        runBlocking { useCase(params, onResult) }
        result.shouldEqual(actualTestResult)
    }

    data class MyType(val name: String)
    data class MyParams(val name: String)

    private inner class MyUseCase : UseCase<MyType, MyParams>() {
        override suspend fun run(params: MyParams) = actualTestResult
    }
}