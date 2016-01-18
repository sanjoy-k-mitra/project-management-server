package com.rootnext.management.security

import grails.plugin.springsecurity.annotation.Secured


@Secured('ROLE_ADMIN')
class UserRoleController {

    static scaffold = UserRole
}
