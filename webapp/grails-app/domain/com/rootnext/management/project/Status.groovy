package com.rootnext.management.project

class Status {
    String name

    static constraints = {
        name(blank: false, unique: true)
    }

    String toString(){
        return name
    }
}
