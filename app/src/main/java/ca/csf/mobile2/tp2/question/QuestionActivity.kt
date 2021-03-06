package ca.csf.mobile2.tp2.question

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import ca.csf.mobile2.tp2.R
import ca.csf.mobile2.tp2.databinding.ActivityQuestionBinding
import org.androidannotations.annotations.*

@SuppressLint("Registered") //Reason : Generated by Android Annotations
@DataBound
@EActivity(R.layout.activity_question)

class QuestionActivity : AppCompatActivity() {


    protected lateinit var questionService : QuestionService
    @InstanceState
    protected lateinit var viewModel : QuestionActivityViewModel

    protected fun onCreate(@BindingObject dataBinder : ActivityQuestionBinding) {
        questionService = QuestionService()
        if(!this::viewModel.isInitialized){
            viewModel = QuestionActivityViewModel(QuestionModel())
            getRandomQuestion()
        }
        dataBinder.viewModel = viewModel

    }
    @Background
    protected fun getRandomQuestion(){
        viewModel.assignLoading()
        questionService.getRandomQuestion(
            this::onQuestionFound,
            this::onConnectionError,
            this::onServerError)
    }

    @Background
    protected fun postChoice1(){
        viewModel.assignLoading()
        questionService.postChoice1Question(
            viewModel.id,
            this::onChoice1Posted,
            this::onConnectionError,
            this::onServerError)

    }

    @Background
    protected fun postChoice2(){
        viewModel.assignLoading()
        questionService.postChoice2Question(
            viewModel.id,
            this::onChoice2Posted,
            this::onConnectionError,
            this::onServerError)

    }

    @Click(R.id.retry_button)
    protected fun onRetryButtonClicked() {
        getRandomQuestion()

    }

    @Click(R.id.choice1_button)
    protected fun onChoice1ButtonClicked(){
        postChoice1()
    }

    @Click(R.id.choice2_button)
    protected fun onChoice2ButtonClicked(){
        postChoice2()
    }

    @Click(R.id.choice1_result_background,R.id.choice2_result_background)
    protected fun onResultBackgroundClicked(){
        getRandomQuestion()
    }

    @UiThread
    protected fun onQuestionFound(question: QuestionModel){
        viewModel.questionModel = question
        viewModel.assignAskingQuestion()
    }

    @UiThread
    protected fun onChoice1Posted(){
        viewModel.assignShowingResults()
    }

    @UiThread
    protected fun onChoice2Posted(){
        viewModel.assignShowingResults()
    }

    @UiThread
    protected fun onConnectionError(){
        viewModel.assignError()
        viewModel.currentError = getString(R.string.text_error_internetEN)
    }

    @UiThread
    protected fun onServerError(){
        viewModel.assignError()
        viewModel.currentError = getString(R.string.text_error_serverEN)
    }
}
