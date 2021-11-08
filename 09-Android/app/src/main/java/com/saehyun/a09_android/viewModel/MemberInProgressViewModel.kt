package com.saehyun.a09_android.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saehyun.a09_android.model.data.PostValue
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

class MemberInProgressViewModel(private val repository: Repository) : ViewModel() {
    val memberInProgressResponse : MutableLiveData<Response<List<PostValue>>> = MutableLiveData()

    fun memberInProgress(memberId: String) {
        viewModelScope.launch {
            val response = repository.memberInProgress(memberId)
            memberInProgressResponse.value = response
        }
    }
}