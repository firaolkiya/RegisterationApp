package com.example.atry.Presentation.Login


sealed class LoginEvent {
    data class fetchUser(val email: String,val password:String):LoginEvent()
}