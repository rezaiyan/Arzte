package ir.alirezaiyan.domain.ext

import ir.alirezaiyan.base.ext.Either
import ir.alirezaiyan.base.ext.Failure
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldEqual
import org.junit.Test


/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 4:23 PM.
 */
class UseCaseTest {


    private val TYPE_TEST = "Test"
    private val TYPE_PARAM = "ParamTest"

    private val useCase = MyUseCase()


    private val actualTestResult = Either.Right(MyType(TYPE_TEST))

    @Test
    fun usecaseTypeTest() {
        val params = MyParams(TYPE_PARAM)
        val result = runBlocking { useCase.run(params) }

        result shouldEqual actualTestResult
    }

    @Test
    fun usecaseResultTest() {
        var result: Either<Failure, MyType>? = null
        val params = MyParams("TestParam")

        val onResult = { myResult: Either<Failure, MyType> -> result = myResult }

        runBlocking { useCase(params, onResult) }

        result shouldEqual actualTestResult
    }

    data class MyType(val name: String)
    data class MyParams(val name: String)

    private inner class MyUseCase : UseCase<MyType, MyParams>() {
        override suspend fun run(params: MyParams) = actualTestResult
    }
}