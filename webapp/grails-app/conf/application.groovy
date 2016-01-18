// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.rootnext.management.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.rootnext.management.security.UserRole'
grails.plugin.springsecurity.authority.className = 'com.rootnext.management.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/oauth/authorize', access: "isFullyAuthenticated() and (request.getMethod().equals('GET') or request.getMethod().equals('POST'))"],
        [pattern: '/oauth/token', access: "isFullyAuthenticated() and request.getMethod().equals('POST')"],
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/oauth/token',               filters: 'JOINED_FILTERS,-oauth2ProviderFilter,-securityContextPersistenceFilter,-logoutFilter,-authenticationProcessingFilter,-rememberMeAuthenticationFilter,-exceptionTranslationFilter'],
        [pattern: '/securedOAuth2Resources/**', filters: 'JOINED_FILTERS,-securityContextPersistenceFilter,-logoutFilter,-authenticationProcessingFilter,-rememberMeAuthenticationFilter,-oauth2BasicAuthenticationFilter,-exceptionTranslationFilter'],
        [pattern: '/**',                        filters: 'JOINED_FILTERS,-statelessSecurityContextPersistenceFilter,-oauth2ProviderFilter,-clientCredentialsTokenEndpointFilter,-oauth2BasicAuthenticationFilter,-oauth2ExceptionTranslationFilter'],

        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

// Added by the Spring Security OAuth2 Provider plugin:
grails.plugin.springsecurity.oauthProvider.clientLookup.className = 'com.rootnext.management.security.oauth2.Client'
grails.plugin.springsecurity.oauthProvider.authorizationCodeLookup.className = 'com.rootnext.management.security.oauth2.AuthorizationCode'
grails.plugin.springsecurity.oauthProvider.accessTokenLookup.className = 'com.rootnext.management.security.oauth2.AccessToken'
grails.plugin.springsecurity.oauthProvider.refreshTokenLookup.className = 'com.rootnext.management.security.oauth2.RefreshToken'

// Added by the Spring Security OAuth2 Provider plugin:
grails.plugin.springsecurity.oauthProvider.approvalLookup.className = 'com.rootnext.management.security.oauth2.UserApproval'

