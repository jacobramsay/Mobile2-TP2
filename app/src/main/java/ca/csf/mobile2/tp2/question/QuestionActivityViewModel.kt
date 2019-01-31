package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import org.parceler.Parcel
import android.os.Parcelable
import android.widget.Button
import org.parceler.ParcelConstructor
import java.util.*

@Parcel(Parcel.Serialization.BEAN)
class QuestionActivityViewModel @ParcelConstructor constructor(questionModel: QuestionModel) : BaseObservable() {

    var isAskingQuestion = false
        private set
    var isShowingResults = false
        private set
    var isHavingError = false
        private set
    var isLoading = false

    var currentError: String = ""
        set(value) {
            field = value
            notifyChange()
        }


    var questionModel: QuestionModel = questionModel
        set(value) {
            field = value
            notifyChange()
        }

    @get:Bindable
    val id: String
        get() = questionModel.id
    @get:Bindable
    val choice1: String
        get() = questionModel.choice1
    @get:Bindable
    val choice2: String
        get() = questionModel.choice2
    @get:Bindable
    val text: String
        get() = questionModel.text
    @get:Bindable
    val choice1Result: String
        get() = questionModel.getChoice1Result()
    @get:Bindable
    val choice2Result: String
        get() = questionModel.getChoice2Result()
    @get:Bindable
    val isFrench: Boolean
        get() = Locale.getDefault().getDisplayLanguage() == ("French");

    fun assignLoading() {
        isAskingQuestion = false
        isShowingResults = false
        isHavingError = false
        isLoading = true
        notifyChange()
    }

    fun assignAskingQuestion() {
        isAskingQuestion = true
        isShowingResults = false
        isHavingError = false
        isLoading = false
        notifyChange()
    }

    fun assignError() {
        isAskingQuestion = false
        isShowingResults = false
        isHavingError = true
        isLoading = false
        notifyChange()
    }

    fun assignShowingResults() {
        isAskingQuestion = false
        isShowingResults = true
        isHavingError = false
        isLoading = false
        notifyChange()
    }
}