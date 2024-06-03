package com.example.atry.Presentation.CreateAccount

sealed class CreateAccountEvent{
    data class isExist(val email:String):CreateAccountEvent()
    data class Register(val name:String,
        val father:String,
        val email: String,
        val password:String):CreateAccountEvent()
}