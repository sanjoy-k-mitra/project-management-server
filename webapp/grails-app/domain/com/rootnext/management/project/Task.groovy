package com.rootnext.management.project

import com.rootnext.management.security.User

class Task {
    String title
    String issueUrl
    String description

    String taskType;
    Integer estimation;

    Date dateCreated;
    Date lastUpdated;

    static hasMany = [
        comments: Comment
    ]

    static belongsTo = [
            project: Project,
            assignee: User
    ]

    static constraints = {
        assignee nullable: true
        description nullable: true
        taskType inList: ["Bug", "Story", "Feature"]
    }

    static mapping = {
        description type: 'text'
    }
}
