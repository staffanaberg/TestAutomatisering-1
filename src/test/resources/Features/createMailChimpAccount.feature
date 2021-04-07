Feature: Create account on mailchimp
As a new user
I want to create an account

@mytag
Scenario Outline:
Given I have entered an "<emailadress>" into the email slot
And I have also entered an "<username>" into the username slot
And I have also entered a "<password>" into the password slot
When I press sign up
Then I will "<verify>" 
Examples:
|emailadress|    username    |    password    |    verify    |

|email      |		 username    |    Password123&|		 Check your email|

|email      |    longUsername|    Password123&|		 Enter a value less than 100 characters long|

|email      |    Ludwig334     |    Password123&|		 Another user with this username already exists. Maybe it's your evil twin. Spooky.|

|						|    username    |    Password123&|	   Please enter a value|



