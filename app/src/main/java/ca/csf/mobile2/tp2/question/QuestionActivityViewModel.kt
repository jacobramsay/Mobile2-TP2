package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import org.parceler.Parcel
import android.os.Parcelable
import android.widget.Button
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
class QuestionActivityViewModel @ParcelConstructor constructor(questionModel: QuestionModel): BaseObservable() {

    var isAskingQuestion = false
    var isShowingResults = false
    var isHavingConnectivityError = false
    var isHavingServerError = false
    var isLoading = false

    var currentError : String = ""
    set(value){
        field = value
        notifyChange()
    }


    var questionModel: QuestionModel = questionModel
    set(value) {
        field = value
        notifyChange()
    }

    @get:Bindable
    val choice1: String
        get() = questionModel.choice1
    val choice2 : String
        get() = questionModel.choice2
    val text : String
        get() = questionModel.text


    fun AssignLoading(){
        isAskingQuestion = false
        isShowingResults = false
        isHavingConnectivityError = false
        isHavingServerError = false
        isLoading = true
        notifyChange()
    }

    fun AssignAskingQuestion(){
        isAskingQuestion = true
        isShowingResults = false
        isHavingConnectivityError = false
        isHavingServerError = false
        isLoading = false
        notifyChange()
    }

    fun AssignConnectivityError(){
        isAskingQuestion = false
        isShowingResults = false
        isHavingConnectivityError = true
        isHavingServerError = false
        isLoading = false
        notifyChange()
    }

    fun AssignServerError(){
        isAskingQuestion = false
        isShowingResults = false
        isHavingConnectivityError = false
        isHavingServerError = true
        isLoading = false
        notifyChange()
    }

    fun AssignShowingResults() {
        isAskingQuestion = false
        isShowingResults = true
        isHavingConnectivityError = false
        isHavingServerError = false
        isLoading = false
        notifyChange()
    }
}