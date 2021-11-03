package com.saehyun.a09_android.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.a09_android.model.request.AuthLoginRequest
import com.saehyun.a09_android.model.response.AuthLoginResponse
import com.saehyun.a09_android.model.response.PostResponse
import com.saehyun.a09_android.repository.Repository
import com.saehyun.a09_android.util.REFRESH_TOKEN
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import java.io.File

class PostSharingViewModel(private val repository: Repository) : ViewModel() {
    val authPostResponse : MutableLiveData<Response<Void>> = MutableLiveData()

    fun authPostSharing(title: RequestBody, content: RequestBody, transactionRegion: RequestBody,
                 openChatLink: RequestBody, image: MultipartBody.Part) {
        viewModelScope.launch {
            val response = repository.postSharing(title, content, transactionRegion, openChatLink, image)
            authPostResponse.value = response
        }
    }
}