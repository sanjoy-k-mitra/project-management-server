package com.rootnext.management.security

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='name,username', includeNames=false, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String name

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	User(String username, String password) {
		this()
		this.username = username
		this.password = password
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this)*.role
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static transients = ['springSecurityService']

	static constraints = {
		name nullable: true
		username blank: false, unique: true, email: true
		password blank: false, password: true, display: false
	}

	static mapping = {
		password column: '`password`'
	}


}
