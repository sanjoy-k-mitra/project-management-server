import com.rootnext.management.project.Status
import com.rootnext.management.security.Role
import com.rootnext.management.security.User
import com.rootnext.management.security.UserRole
import com.rootnext.management.security.oauth2.Client

class BootStrap {

    static String REDIRECT_URI = "http://localhost/callback.php"

    def init = { servletContext ->
        if (Status.count() == 0) {
            new Status(name: 'Open').save(flush: true)
            new Status(name: 'In Development').save(flush: true)
            new Status(name: 'In Design').save(flush: true)
            new Status(name: 'Testing').save(flush: true)
            new Status(name: 'Complete').save(flush: true)
            new Status(name: 'Closed').save(flush: true)
        }

        environments {
            development {
                if (User.count() == 0) {
                    Role userRole = new Role(authority: 'ROLE_USER').save(flush: true)
                    Role adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)

                    User user = new User(username: 'sanjoy@rootnext.com', password: 'san1oy').save(flush: true)
                    User admin = new User(username: 'admin@rootnext.com', password: 'admin').save(flush: true)

                    UserRole.create(user, userRole, true)
                    UserRole.create(admin, adminRole, true)

                }


                if (Client.count() == 0) {
                    new Client(
                            clientId: 'client-app',
                            clientSecret: 'aquickbrownfox',
                            authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
                            authorities: ['ROLE_TRUSTED_CLIENT'],
                            scopes: ['read', 'write', 'delete', 'trust', 'test'],
                            redirectUris: [REDIRECT_URI]
                    ).save(flush: true)
                }
            }
            production {

            }
        }
    }
    def destroy = {
    }
}
