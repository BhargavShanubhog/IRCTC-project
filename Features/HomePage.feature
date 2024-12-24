Feature: Home Page

    Background: 
    Given Open url "https://www.air.irctc.co.in/"in any driver
    And Type origin and Destination place
    And Select a particular month and date
    Then Click on Search button
  
   
    
    
    
    Scenario: Verify by giving all credentials with any one radio button
    When Select any one radio button
    
   
   Scenario: Verify by giving all credentials with any two radio buttons
    When Select any two radio buttons
    
    
   
   Scenario: Verify by giving all credentials with all three radio buttons
    When Select all three radio buttons
    
    
    Scenario Outline: Verify by giving all credentials DDT
    
    And Type "<origin>" and "<Destination>" place
    And Select a particular "<month>" and "<date>"
    Then Click on Search button
    Examples: 
      | origin    | Destination | month     | date |
      |           | Bengaluru   | March     |   29 |
      | Bengaluru |             | July      |   26 |
      | Mumbai    | Hyderabad   |           |   11 |
      | Ahmedabad | Delhi       | September |      |
    
  
    
  
