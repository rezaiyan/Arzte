package ir.alirezaiyan.base.ext

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/8/2020 1:57 AM.
 */
sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object EndOfList : Failure()
}