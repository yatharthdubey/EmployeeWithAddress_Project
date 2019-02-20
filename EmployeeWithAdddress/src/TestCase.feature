#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Employee Management System

  @tag1
  Scenario: Create an Employee
    Given id= 101, name= "Yatharth" 
    And addressLine = "xyz", Country.name= "India", City.name = "Agra"
    When createAccount() method is invoked using AccountServiceImpl object
    Then Validation takes place
    And Employee details gets stored in Collection using save() method 

  @tag2
  Scenario: Try to create Employee while passing id as negative
    Given id=-100, name = "Yatharth"
    And addressLine = "xyz", Country.name= "India", City.name = "Agra"
    When createAccount() method is invoked using AccountServiceImpl object
    Then exception occurs and gets thrown to main block
    And that Exception will be handled by catch block by printing error message as NegativeEmployeeIdException

  @tag3
  Scenario: Try to create Employee while passing duplicate id
    Given id=100, name = "Yatharth"
    And addressLine = "xyz", Country.name= "India", City.name = "Agra" is there in storage
    And id=100, name = "Yatharth1"
    And addressLine = "xyz1", Country.name= "India1", City.name = "Agra1" is passed
    When createAccount() method is invoked using AccountServiceImpl object
    Then exception occurs and gets thrown to main block
    And that Exception will be handled by catch block by printing error message as DuplicateEmployeeIdException
  
  @tag4
  Scenario: Try to create Employee while passing name as null or empty
    Given id= 101, name= "" or name = null
    And addressLine = "xyz", Country.name= "India", City.name = "Agra" is there in storage
    When createAccount() method is invoked using AccountServiceImpl object
    Then exception occurs and get thrown main block
    And that Exception will be handled by catch block by printing error message as NameCannotBeEmptyException

  @tag5
  Scenario: Try to create Employee while passing address object as null
    Given id= 101, name= "Yatharth" 
    And address = null
    When createAccount() method is invoked using AccountServiceImpl object
    Then exception occurs gets thrown in main block
    And that Exception will be handled by catch block by printing error message as NoAddressFieldMustBeEmptyException

  @tag6
  Scenario: Try to create Employee while passing any of the address field as null
    Given id= 101, name= "Yatharth" 
    And addressLine = null or Country.name = null or City.name = null
    When createAccount() method is invoked using AccountServiceImpl object
    Then exception occurs gets thrown to main block
    And that will be handled by catch block by printing error message as NoAddressFieldMustBeEmptyException
 
  @tag7
  Scenario: Search an Employee
    Given id= 101, name= "Yatharth" 
    And addressLine = "xyz", Country.name= "India", City.name = "Agra" is there in storage
    And name = "Yatharth" is passed
    When searchByName() method is invoked using AccountServiceImpl object
    Then List of Employee with given name is returned

  @tag8
  Scenario: Try to search for Employee details while passing name empty as null
    Given id= 101, name= "Yatharth" 
    And addressLine = "xyz", Country.name= "India", City.name = "Agra" is there in storage
    And name = "" is passed
    When searchByName() method is invoked using AccountServiceImpl object
    Then exception occurs gets thrown to main block
    And that will be handled by catch block by printing error message as NameNotFoundException
  
  @tag9
  Scenario: Try to search for Employee details while passing a different name
    Given id= 101, name= "Yatharth" 
    And addressLine = "xyz", Country.name= "India", City.name = "Agra" is there in storage
    And name = "Dubey" is passed
    When searchByName() method is invoked using AccountServiceImpl object
    Then exception occurs gets thrown to main block
    And that will be handled by catch block by printing error message as NameNotFoundException
  
