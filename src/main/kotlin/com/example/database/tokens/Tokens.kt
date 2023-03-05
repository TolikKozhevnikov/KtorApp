package com.example.database.tokens

import com.example.database.tokens.TokenDTO

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object Tokens: Table("tokens") {
    private val id = Tokens.varchar("id", 25)
    private val login = Tokens.varchar("login", 25)
    private val token = Tokens.varchar("token", 50)

    fun insert(tokenDTO: TokenDTO){
        transaction {
            Tokens.insert {
                it[login] = tokenDTO.login
                it[id] = tokenDTO.rowId
                it[token] = tokenDTO.token
            }
        }

    }
}