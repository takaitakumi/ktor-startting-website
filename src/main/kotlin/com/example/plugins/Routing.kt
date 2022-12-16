package com.example.plugins

import com.example.models.articles
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {


    routing {
        get("/") {
            call.respondText("articles")
        }
        route("articles") {
            get {
                // show a list of articles
                call.respond(FreeMarkerContent("index.ftl", mapOf("articles" to articles)))
            }
            get("new") {
                // show a page with fields for creating a new article
            }
            post {
                // save an article
            }
            get("{id}") {
                // show an article with a specific id
            }
            get("{id}/edit") {
                // show a page with fields for editing an article
            }
            post("{id}") {
                // update or delete an article
            }
        }

        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static") // 必须放在resources下面
        }
    }
}
