#   [About abstract class]()                   
##  [`Abstract Classes Compared to Interfaces`]
### Abstract class
  - can declare fields that are not static and final, and define public, protected, and private concrete methods.
### Interfaces
  - all fields are automatically public, static, and final
  - all methods that you declare or define (as default methods) are public.
##  [`Which should you use, abstract classes or interfaces?`]
### Consider using abstract classes if any of these statements apply to your situation:
  - You want to share code among several closely related classes.
  - You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
  - You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.
### Consider using interfaces if any of these statements apply to your situation:
  - You expect that unrelated classes would implement your interface. For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
  - You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
  - You want to take advantage of multiple inheritance of type.


#   [About Enumeration java]()
##  [`Characteristic`]
  - The Enum in Java is a data type which contains a fixed set of constants
  - An enum is a special "`class`" that represents a group of constants (`unchangeable variables, like final variables`).
##  [`Point to remember for java enum`]  
  - Enum improves type safety
  - Enum can be easily used in switch
  - Enum can be traversed
  - Enum can have `fields`, `constructors` and `methods`
  - Enum may implement many interfaces but cannot extend any class because it internally extends Enum class


#  [Spring Core]() 
## [`Dependency injection`]
## [`Spring IOC`]
## [`Spring AOP`]
## [`Spring Bean Scope`]
## [`Spring Bean Config Styles (java and annotation based)`]
## [`Avaliable annotations`]
## [`Secheduling`]


# [Spring Security]()
* Encoding   => no keys (Base64,...)
* Encryption => need keys (AES, DES, ...)
* Hashing    => no keys (one way, Bcrypt)
* Authentication --|
*                  | => app-level Security 
* Authorization  --|  

  ## [`Authentication`]
     ### Basic Authentication
     *    Http basic
          - password use basic Encoding

  ## [`Authorization`]
 

##  [OAuth2]()
*   What is OAuth2?
##  [`Dependency`]
``` 
    dependencies {
       implementation 'org.springframework.boot:spring-boot-starter-oauth2-resource-server'
    }
```    
##  [`YML`]
``` 

```
### Database jpa entity
*   TB_UserInfo:
    - id
    - userId
    - userName
    - userPassword
    - userPassword
    - .............
### SignUp
*   [payload]()
    - TaxId
    - `BusinessName` :
    - `RepresentativeName` :
    - `address`
    - `cityCode`
    - `nationalCode`
    - `fullname`
    - `email`
    - `userId`
    - `password`
    - phonenumber
    - securityCode
    - securityKey
*   [Process SignUp On FrontEnd]()
    - step1 -> `TaxId` :  Enter to check whether your company has been registered already.
    - step2 -> 
    - step3 ->
*   [Process SignUp On Backend]()
    * [Protect Security]
      - When enter `phonenumber`, `securityCode`, `securityKey` on backend must be [Bcrypt].
      - Get `security code` and `security key` from OTP backend
      - Check `security code` expired
      - Check `security key` not found
    - Step1 -> [Decryption]
      - `phonenumber` : decrypt from payload
      - `securityCode`: decrypt from payload
      - `securityKey` : decrypt from payload
    - Step2 -> [check security code expired]
    - Step3 -> [check security key not found]
    - Step4 -> [Check userId exist]

### Login
*   payload:
    - `userId` : Must be encryption
    - `email`  : Must be encryption
###  ForgotPassword
*    ForgotPasswordByEmail
*    ForgotPasswordByPhone
###  ForgotUserId
*    ForgotUserIdByEmail
*    ForgotUserIdByPhone
###  ResetPassword


#   [OTP]()
### Configuration
* yml
##  [`send OTP`]
- Post
##  [`Verify OTP`]
- Post


#    [Send sms]()


#    [Send email]()


## [`Password`]
+ FrontEnd password:
+ FrontEnd password:
+ FrontEnd password:
  ```
  - b
  - e
  ``` 
+ BackEnd password:
  ```
  - bycript password
   
  ```
+ encrypt and decrypt
  ```  
   - System.err.println(PasswordUtils.encrypt("vuthin123"));
   - System.err.println(PasswordUtils.decrypt("Gi5+5x6NmDq5xwn2kqFXbA=="));
  ```
+ Password Change:
# [Send mail]()
- Dependencies


# [Validation]()
## [`Empty( no white space [""] )`]
    * An empty value is a value that has no content. 
    Example : 
        - String  : ""
        - List    : []
## Blank ( white space [" "])
    A blank value is a value that is empty or contains only whitespace characters. 
    For example :
        - String   : “ “
        - List     : [ ]
## Notnull 
    A notnull value is a value that is not null.
    This means that the value must have a non-null value, but it can be empty or blank.
    Example  :
        - String  :  “abc”
        - List    : [1,2,3] mm

# JPA [Relationship]()

### [ManyToOne]
+ Annotations:
  - @ManyToOne   
  - @JoinColumn 

### @ManyToOne properties Annotations

### @JoinColumn ManyToOne properties Annotations


```
    @ManyToOne
    @JoinColumn(name = "author_id") // Defines the foreign key column
    private Author author;
```

### Cascading:
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

### Fetch Type:
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

### Bidirectional Relationships:
    
    @Entity
    public class Author {

        @OneToMany(mappedBy = "author")
        private List<Book> books;
    }

# JPA
    There are several JPA implementations available, but the most popular ones are:
        Hibernate
        EclipseLink
        Apache OpenJPA
        DataNucleus
        CMobileCom JPA
`
fffsdfdfsdfdf
`

# 1. JPA Core Concept

## Entities

## Entity managers

##  JPQL

## Criteria API
---

# #JPA

## JPA Derive

## JPA JPQL
    note
``  notion
``
## JPA Criteria
    note

## JPA Native
    Note

--- 
# DATABASE
    DBMS :
        - Microsoft Access
        - SQL Server
        - Oracle 
        - MySQL
        .........
`
SQL គឺជាភាសាមួយដែលត្រូវបានប្រើនៅក្នុងគ្រប់ DBMS ទាំងអស់ ដែលមាននាទីបង្កើត Table ...
`

## I. DDL ( `Data definition language` )

    Create, Modify, and Delete Table.

### 1.1 Create Table

    CREATE TABLE Table_name (
        Field_name1 Datatype [ Constraint1 ],
        ...
        Field_nameN Datatype [ ConstraintN ],
        [ ConstraintExpressions ]
    )

##### Constraint

    + Constraint1 ... ConstraintN គឺជាការកំណត់គោលការណ៍ ឬ លក្ខខណ្ឌសំរាប់ Field នីមួយៗ :
        - Primary key
        - Not null

#### ConstraintExpressions

    + ConstraintExpressions គឺជាការបង្កើតកន្សោម ឬ លក្ខខណ្ឌ
        - forence key
        - on delete cascade on delete cascade

#### Create Table OneToOne

    create

#### Create Table OneToMany

    OneToMany

#### Create Table ManyToOne

    ManyToOne

#### Create Table ManyToMany

    ManyToMany

### 1.2 Update Table

### 1.3 Delete Table

## II. DML




    


       







    