package com.example.activitylifecycle

import android.os.Parcel
import android.os.Parcelable

class Person( val name : String , val age : Int ) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString()!!,parcel.readInt()) {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(this.name)
        parcel.writeInt(this.age)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}