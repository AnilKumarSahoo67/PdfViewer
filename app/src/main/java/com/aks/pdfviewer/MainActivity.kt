package com.aks.pdfviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aks.pdfviewer.utils.saveTo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = PdfViewerActivity.launchPdfFromUrl(
            this,
            "http://www.clickdimensions.com/links/TestPDFfile.pdf",
            "Anil",
            saveTo.DOWNLOADS,
            true,
        )
        startActivity(intent)
    }
}