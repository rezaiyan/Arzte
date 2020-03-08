package ir.alirezaiyan.base.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Ali (alirezaiyann@gmail.com)
 * @since 3/6/2020 11:05 AM.
 */


abstract class EndlessOnScrollListener : RecyclerView.OnScrollListener() {

    private var mPreviousTotal = 0
    private var mLoading = true
    private var reachEnd = false
    private val visibleThreshold = 1

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView.childCount
        val totalItemCount = recyclerView.layoutManager!!.itemCount
        val firstVisibleItem =
            (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

        if (mLoading) {
            if (totalItemCount > mPreviousTotal) {
                mLoading = false
                mPreviousTotal = totalItemCount
            }
        }

        if (!reachEnd && !mLoading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            onLoadMore()
            mLoading = true
        }
    }

    abstract fun onLoadMore()
    fun onFailure() {
        mLoading = false
    }

    fun onReachEnd() {
        reachEnd = true
        mLoading = false
    }
}
