package ca.csf.mobile2.tp2.question

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.androidannotations.annotations.Background
import org.androidannotations.annotations.EBean
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.create
import retrofit2.http.*
import java.io.IOException

class QuestionService {

    private val service: Service

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://m2t2.csfpwmjv.tk/")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().registerKotlinModule()))
            .build()

        service = retrofit.create(Service::class.java)
    }

    fun getRandomQuestion(
        onSuccess: (QuestionModel) -> Unit,
        onConnectivityError: () -> Unit,
        onServerError: () -> Unit
    ) {
        try {
            val response = service.getRandomQuestion().execute()
            if (response.isSuccessful) {
                onSuccess(response.body()!!)
            } else {
                onServerError()
            }

        } catch (e: IOException) {
            onConnectivityError()

        }
    }

    fun postChoice1Question(
        id: String,
        onSuccess: () -> Unit,
        onConnectivityError: () -> Unit,
        onServerError: () -> Unit
    ) {
        try {
            val reponse = service.postChoice1Question(id).execute()
            if (reponse.isSuccessful) {
                onSuccess()
            } else {
                onServerError()
            }
        } catch (e: IOException) {
            onConnectivityError()
        }
    }

    fun postChoice2Question(
        id: String,
        onSuccess: () -> Unit,
        onConnectivityError: () -> Unit,
        onServerError: () -> Unit
    ) {
        try {
            val reponse = service.postChoice2Question(id).execute()
            if (reponse.isSuccessful) {
                onSuccess()
            } else {
                onServerError()
            }
        } catch (e: IOException) {
            onConnectivityError()
        }
    }

    private interface Service {
        @GET("/api/v1/question/random")
        fun getRandomQuestion(): Call<QuestionModel>

        @POST("/api/v1/question/{id}/choose1")
        fun postChoice1Question(@Path("id") id: String): Call<QuestionModel>

        @POST("/api/v1/question/{id}/choose2")
        fun postChoice2Question(@Path("id") id: String): Call<QuestionModel>
    }
}
