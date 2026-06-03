package com.example.labwork27.data

class UserService {
    var userList: MutableList<User> = mutableListOf()
    fun addUser(user: User){
        userList.add(user)
    }
}