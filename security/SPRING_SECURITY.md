# [SPRING SECURITY]()
* Http request      =>
* Filter chain      => 
* DispactherServlet =>
---

## [How Spring Security Work?]()
### Authentication Filter [ username:passwrod ]
*   Basic Authentication
    - `BasicAuthenticationFilter` extends `OncePerRequestFilter`
    - dfds
### Authentication Manager
### Authentication Provider
  - UserDetailService
  - PasswordEnCoder
### Security Context
---

### @Configuration:
* No need password basic generate of spring 
* Make own password and user


---
## [ 5 Core Concept of spring Security ]()
* Authentication 
* Authorization
* Principal
* Granted Authority 
* Roles
---
### What is Authentication?
* Who this user?
### What is Authorization?
* Are they allowed to do this?
### Pricipal?
* Currently logged in user
* One user can have multiple IDs
### Granted Authority?

### Rols?
* Rols is group of Authority?
*
---
* Custom Authentication which will authenticate requests based on a key present in the header of the request.
* Valid application key is stored in app configurations.
* Security Config (Wire up the authentication filter in the spring context)
* Agthentication `Filter` ( Intercept the request, create authentication object and pass it to authentication manager)
* Authentication `Manayer` (Invoke the correct authentication provider as per request)
* Authentication `Provider` (Perform evaluation to decide whether to mark the request authorized or unauthorized)
* Authentication `Object` (contains authentication status authorized(true) unauthorized(false))

# [Spring Security 6]()

