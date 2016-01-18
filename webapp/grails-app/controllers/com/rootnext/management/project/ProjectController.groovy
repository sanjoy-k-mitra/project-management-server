package com.rootnext.management.project

import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_USER')
class ProjectController {

    static scaffold = Project
}
