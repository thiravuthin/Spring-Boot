# [SPRING SECURITY]()

key concepts and keywords that you should be familiar with. Here's a list of important terms related to Spring Boot Security:

* **Authentication**:
  - `Principal`: Represents the currently authenticated user.
  - `Credentials`: The information used to verify the identity of a user, such as a password.

* **Authorization**:
  - `Roles and Authorities`: Roles are typically associated with broad categories of access, while authorities are more fine-grained permissions.
  - `Granted Authority`: Represents a permission or authority granted to a principal.
* **Security Configuration**:
  - `SecurityConfigurer`: Allows customization of the security filter chain.
  - `WebSecurityConfigurerAdapter`: A convenience class for creating a SecurityConfigurer.
* **Authentication Providers**:
  - `AuthenticationProvider`: Responsible for authenticating a user.
  - `UserDetailsService`: Interface to load user-specific data.
* **Security Filters**:
  - `UsernamePasswordAuthenticationFilter`: Handles authentication based on username and password.
  - `BasicAuthenticationFilter`: Performs basic HTTP authentication.
  - `JwtAuthenticationFilter`: Handles authentication using JSON Web Tokens (JWT).
* **Security Annotations**:
  - `@Secured`: Used to secure a method or class.
  - `@PreAuthorize, @PostAuthorize`: Provide expression-based access control.

* **Password Encryption**:
PasswordEncoder: Interface for encoding and verifying passwords.
BCryptPasswordEncoder, Pbkdf2PasswordEncoder: Implementations of PasswordEncoder using different algorithms.

Session Management:

Concurrent Session Control: Limiting the number of active sessions per user.
SessionRegistry: Keeps track of all active sessions.

OAuth 2.0:

@EnableOAuth2Sso: Enables OAuth 2.0 Single Sign-On (SSO) in a Spring Boot application.
OAuth2ClientProperties: Configuration properties for OAuth 2.0 clients.
CSRF Protection:

Cross-Site Request Forgery (CSRF): Protects against CSRF attacks.
CsrfToken: Represents a CSRF token.
Customization and Events:

AuthenticationSuccessHandler, AuthenticationFailureHandler: Customize behavior after successful/failed authentication.
AuthenticationEvent: Events fired during authentication.
Actuator Endpoints:

/actuator/info, /actuator/health: Endpoints to expose application information and health status.
Method Security:

@Secured, @PreAuthorize, @PostAuthorize: Annotations for securing methods.
GlobalMethodSecurity: Enables global method security.
Security Headers:

Content-Security-Policy, X-Frame-Options: Headers for controlling browser security policies.

* Security Properties:

security.user: Default user properties.
security.basic: Basic authentication properties.
security.oauth2: OAuth 2.0 client and resource properties.

## [How Spring Security Work?]()
---
* Http request      =>
* Filter chain      =>
* DispactherServlet =>
---
* SecurityFilterChain ->
* UserDetailService   ->