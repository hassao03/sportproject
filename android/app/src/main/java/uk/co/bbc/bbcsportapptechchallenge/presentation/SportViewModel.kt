package uk.co.bbc.bbcsportapptechchallenge.presentation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class SportViewModel(val data: @RawValue Data) : Parcelable