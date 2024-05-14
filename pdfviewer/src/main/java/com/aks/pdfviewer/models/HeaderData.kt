package com.aks.pdfviewer.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeaderData(val headers: Map<String, String> = emptyMap()) : Parcelable