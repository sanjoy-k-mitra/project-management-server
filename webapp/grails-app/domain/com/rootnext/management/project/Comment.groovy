package com.rootnext.management.project

import com.rootnext.management.security.User

class Comment {
    String text

    static belongsTo = [
            user: User,
            task: Task,
            comment: Comment
    ]

    static constraints = {
        comment nullable: true
    }

    static mapping = {
        text type: 'text'
    }
}
