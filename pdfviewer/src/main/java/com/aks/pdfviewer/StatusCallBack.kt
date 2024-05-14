package com.aks.pdfviewer

interface StatusCallBack {
    fun onPdfLoadStart()
    fun onPdfLoadProgress(progress: Int, downloadedBytes: Long, totalBytes: Long?)
    fun onPdfLoadSuccess(absolutePath: String)
    fun onError(error: Throwable)
    fun onPageChanged(currentPage: Int, totalPage: Int)
}