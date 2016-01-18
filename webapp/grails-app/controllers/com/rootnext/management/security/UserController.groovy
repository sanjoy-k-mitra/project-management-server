package com.rootnext.management.security

import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_ADMIN')
class UserController {

    static scaffold = User
}
