# [SPRING SECURITY]()

*  => In Memory User
*  => Database
*  => jwt

### [ Some keys word ]()
*   Authentication   : ការផ្ទៀងផ្ទាត់ភាពត្រឺមត្រូវ
*   authorization    : ការអនុញ្ញាត្ត = access control = ការគ្រប់គ្រងការចូលប្រើ
*   Authenticated    : 
*   GrantedAuthority : 
---

### [ Some Method with Spring Security ]()
*   [ HttpSecurity]()          : Define endpoint which user/admin... can access?
*   [ AuthenticationFilter]()  :
*   [ AuthenticationManager]() :
*   [ AuthenticationProvider]():
      - UserDetails Service
      - Password Encoder
*   [ UserDetail]()            : Store information of user
*   [ UserDetailService]()     : Load User from DB
---

* [`AuthenticationProvider`]: 
  - UserDetailService:
  - Password Encoder:
  - Authentication:
* GrantedAuthority : What allow user to use
  - Authority: Action [ write, read, delete , excute ]
  - Roles: [ Admin, Manager, client, visitor ]
---

##  [ SpringFramework Security Core]()
### [UserDetails]()
*   UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
### GrantedAuthority:
---

## [How Spring Security Work?]()
* Step1 -> Filter
* Step2 -> HttpBasic
* Step3 -> Authentication Manager
* Step4 -> Authentication Provider
  - Bean
    - UserDetailService
    - PasswordEncoder


####  [AuthenticationProvider](): [ The authentication provider finds the user with a user details service and validates the password using a password encoder. ] 
      SecurityConfig 
      - Bean : UserDetailService ( loadUser from DB ) 
      - Bean : PasswordEncoder
####  [AuthenticationManager]():  [ An extension of the UserDetailsService which provides the ability to create new users and update existing ones ]
      - create, update, delete...
####  [AuthenticationFilter]():
####  [SecurityContext](): 

---
### [Class Basic Build in Authorization]()
*   `BasicAuthenticationFilter` extends `OncePerRequestFilter`
* 

---

### [ Class ]
*   Configuration : Handle custom own `User` and `Password`
    - UserDetailsService : 


  
key concepts and keywords that you should be familiar with. Here's a list of important terms related to Spring Boot Security:
* **[Authentication]()**:
  - `Principal`: Represents the currently authenticated user.
  - `Credentials`: The information used to verify the identity of a user, such as a password.
* **[Authorization]()**:
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
  - `PasswordEncoder`: Interface for encoding and verifying passwords.
  - `BCryptPasswordEncoder`, Pbkdf2PasswordEncoder: Implementations of PasswordEncoder using different algorithms.

* **Session Management**:
  `Concurrent Session Control`: Limiting the number of active sessions per user.
  `SessionRegistry`: Keeps track of all active sessions.

* **OAuth 2.0**:
  @EnableOAuth2Sso: Enables OAuth 2.0 Single Sign-On (SSO) in a Spring Boot application.
  OAuth2ClientProperties: Configuration properties for OAuth 2.0 clients.

* **CSRF Protection**:
  Cross-Site Request Forgery (CSRF): Protects against CSRF attacks.
  CsrfToken: Represents a CSRF token.

* **Customization and Events**:
  AuthenticationSuccessHandler, AuthenticationFailureHandler: Customize behavior after successful/failed authentication.
  AuthenticationEvent: Events fired during authentication.

* **Actuator Endpoints**:
  /actuator/info, /actuator/health: Endpoints to expose application information and health status.

* **Method Security**:
  @Secured, @PreAuthorize, @PostAuthorize: Annotations for securing methods.
  GlobalMethodSecurity: Enables global method security.

* **Security Headers**:
  Content-Security-Policy, X-Frame-Options: Headers for controlling browser security policies.

* Security Properties:

security.user: Default user properties.
security.basic: Basic authentication properties.
security.oauth2: OAuth 2.0 client and resource properties.
---
*************************** ( Spring Security : Laur Spilca ) *****************************
---
##  [ Lesson1 ]( )
*   [ App-Level Security]()
    - Authentication 
    - Authorization
*   [ Authorization]()
    - GratedAuthority => Authority => Have ( read, Write , delete , change , ....)
    - Role                         => Are  ( user, manager, admin, client, someone ,..... )
*   [ Authentication Type ](KineOfSpringSecurity)
    - Http Basic ( default basic of spring security )
    - CSRT
    - JWT ( OAuth2 )
    - .....
*   [ Password]()
    - Encoding       => no key ( )
      - 
    - Encryption     => has key ( )
      - 
    - Hash function  => no key ( )
      - 
*   [ package springframework.security.core.userdetails]()
    - `interface UserDetailsService`
      - func => UserDetails : loadUserByUsername
*   [ package springframework.security.crypto.password]()
    - `interface PasswordEncoder`
       - func => encode
       - func => matches
       - func => upgradeEncoding
---

# Class 
* SecurityConfig
  - Bean => UserDetailsService : LoadUserByUsername
  - Bean => PasswordEncoder    : 
---

## [Lesson 2]()
*  