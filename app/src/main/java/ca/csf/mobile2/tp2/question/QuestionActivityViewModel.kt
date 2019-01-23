package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import org.parceler.Parcel
import android.os.Parcelable
import android.widget.Button
import org.parceler.ParcelConstructor


class QuestionActivityViewModel (questionModel: QuestionModel?): BaseObservable() {
var questionModel: QuestionModel? = questionModel
    set(value) {
        field = value
        notifyChange()
    }

    @get:Bindable
    val choice1: String
        get() = questionModel!!.choice1
    val choice2 : String
        get() = questionModel!!.choice2
}