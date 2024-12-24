Feature: Selection Page

  Background: Steps common for all scenarios
    Given User launch chrome browser
    When User opens URL
    And User enters origin  and destination
    And User enters departure date 
    Then User clicks Search button
    Then Select Economy mode

  Scenario: Compare displayed date with given date
    And compare both the dates

  Scenario: Add maximum no of adult travellers in Economy mode
    When select travellers option
    And Verify maximum no of adult travllers
    

  Scenario: Add maximum no of child travellers in Economy mode
    When select travellers option
    And Verify maximum no of child travllers
    

  Scenario: Add maximum no of infant travellers in Economy mode
    When select travellers option
    And Verify maximum no of infants travllers
    

  Scenario: Add child travellers in Economy mode when adult travellers are 9
    When select travellers option
    And keep pressing + button beside child option
    

  Scenario: Add adult travellers in Economy mode when child travellers are 8
     When select travellers option
    And keep pressing + button beside adult option
    

  Scenario: is possible to make adult count into zero in economy mode
    When select travellers option
    And keep pressing - button beside adult option
   

  Scenario: is possible to make infant count more than adult count economy mode
    When select travellers option
    And keep pressing + button beside infant option
   

  Scenario: is possible to reduce infant count along with decreasing of adult count when both are same economy mode
    When select travellers option
    And check by reducing adult count
    

  Scenario: is possible to reduce infant count along with decreasing of adult count when  adults are more than infants economy mode
    When select travellers option
    And observe infant count
    

  Scenario: is possible to reduce adult count along with decreasing of infant count when both are same economy mode
    When select travellers option
    And keep pressing - button beside infant option
    
    
   
    

  Scenario Outline: Select flight company name in Economy mode
    When select travellers option
    And select  any "<flight>"  company
    Examples: -
      | flight            |
      | All Airlines      |
      | Air India         |
      | Air India Express |
      | IndiGo            |
      | SpiceJet Ltd      |
      | Akasa Air         |
      | Alliance Air      |
      | Star Air          |
      | Vistara Airline   |
      
      
      
  Scenario: Select Defence Radio button
  When Click on Defence Radio button
  
  Scenario: Add maximum no of adult travellers in Economy mode
    When select travellers option
    And Verify maximum no of adult travllers
    

  Scenario: Add maximum no of child travellers in Economy mode
    When select travellers option
    And Verify maximum no of child travllers
    

  Scenario: Add maximum no of infant travellers in Economy mode
    When select travellers option
    And Verify maximum no of infants travllers
    

  Scenario: Add child travellers in Economy mode when adult travellers are 9
    When select travellers option
    And keep pressing + button beside child option
    

  Scenario: Add adult travellers in Economy mode when child travellers are 8
     When select travellers option
    And keep pressing + button beside adult option
    

  Scenario: is possible to make adult count into zero in economy mode
    When select travellers option
    And keep pressing - button beside adult option
   

  Scenario: is possible to make infant count more than adult count economy mode
    When select travellers option
    And keep pressing + button beside infant option
   

  Scenario: is possible to reduce infant count along with decreasing of adult count when both are same economy mode
    When select travellers option
    And check by reducing adult count
    

  Scenario: is possible to reduce infant count along with decreasing of adult count when  adults are more than infants economy mode
    When select travellers option
    And observe infant count
    

  Scenario: is possible to reduce adult count along with decreasing of infant count when both are same economy mode
    When select travellers option
    And keep pressing - button beside infant option
    
    
   
    

  Scenario Outline: Select flight company name in Economy mode
    When select travellers option
    And select  any "<flight>"  company
    Examples: -
      | flight            |
      | All Airlines      |
      | Air India         |
      | Air India Express |
      | IndiGo            |
      | SpiceJet Ltd      |
      | Akasa Air         |
      | Alliance Air      |
      | Star Air          |
      | Vistara Airline   |
      
 Scenario: Select Senior Citizen radio button
 When Click on Senior Citizen radio button
 
 
 
 Scenario: Add maximum no of adult travellers in Economy mode
    When select travellers option
    And Verify maximum no of adult travllers
    

 Scenario Outline: Select flight company name in Economy mode
    When select travellers option
    And select  any "<flight>"  company
    Examples: -
      | flight            |
      | All Airlines      |
      | Air India         |
      | Air India Express |
      | IndiGo            |
      | SpiceJet Ltd      |
      | Akasa Air         |
      | Alliance Air      |
      | Star Air          |
      | Vistara Airline   |

 Scenario: Select Student radio button
 When Click on Student radio button
 
 
 
 Scenario: Add maximum no of adult travellers in Economy mode
    When select travellers option
    And Verify maximum no of adult travllers
    

 Scenario Outline: Select flight company name in Economy mode
    When select travellers option
    And select  any "<flight>"  company
    Examples: -
      | flight            |
      | All Airlines      |
      | Air India         |
      | Air India Express |
      | IndiGo            |
      | SpiceJet Ltd      |
      | Akasa Air         |
      | Alliance Air      |
      | Star Air          |
      | Vistara Airline   |
      
      
  Scenario: Verify in Business mode
  Then Select Business mode
  
  Scenario: Add maximum no of adult travellers in Economy mode
    When select travellers option
    And Verify maximum no of adult travllers
    

  Scenario: Add maximum no of child travellers in Economy mode
    When select travellers option
    And Verify maximum no of child travllers
    

  Scenario: Add maximum no of infant travellers in Economy mode
    When select travellers option
    And Verify maximum no of infants travllers
    

  Scenario: Add child travellers in Economy mode when adult travellers are 9
    When select travellers option
    And keep pressing + button beside child option
    

  Scenario: Add adult travellers in Economy mode when child travellers are 8
     When select travellers option
    And keep pressing + button beside adult option
    

  Scenario: is possible to make adult count into zero in economy mode
    When select travellers option
    And keep pressing - button beside adult option
   

  Scenario: is possible to make infant count more than adult count economy mode
    When select travellers option
    And keep pressing + button beside infant option
   

  Scenario: is possible to reduce infant count along with decreasing of adult count when both are same economy mode
    When select travellers option
    And check by reducing adult count
    

  Scenario: is possible to reduce infant count along with decreasing of adult count when  adults are more than infants economy mode
    When select travellers option
    And observe infant count
    

  Scenario: is possible to reduce adult count along with decreasing of infant count when both are same economy mode
    When select travellers option
    And keep pressing - button beside infant option
    
    
   
    

  Scenario Outline: Select flight company name in Economy mode
    When select travellers option
    And select  any "<flight>"  company
    Examples: -
      | flight            |
      | All Airlines      |
      | Air India         |
      | Air India Express |
      | IndiGo            |
      | SpiceJet Ltd      |
      | Akasa Air         |
      | Alliance Air      |
      | Star Air          |
      | Vistara Airline   |
      
      
   Scenario: Verify Premium Economy mode
   Then Select Premium Economy mode
   
   
   Scenario: Add maximum no of adult travellers in Economy mode
    When select travellers option
    And Verify maximum no of adult travllers
    

  Scenario: Add maximum no of child travellers in Economy mode
    When select travellers option
    And Verify maximum no of child travllers
    

  Scenario: Add maximum no of infant travellers in Economy mode
    When select travellers option
    And Verify maximum no of infants travllers
    

  Scenario: Add child travellers in Economy mode when adult travellers are 9
    When select travellers option
    And keep pressing + button beside child option
    

  Scenario: Add adult travellers in Economy mode when child travellers are 8
     When select travellers option
    And keep pressing + button beside adult option
    

  Scenario: is possible to make adult count into zero in economy mode
    When select travellers option
    And keep pressing - button beside adult option
   

  Scenario: is possible to make infant count more than adult count economy mode
    When select travellers option
    And keep pressing + button beside infant option
   

  Scenario: is possible to reduce infant count along with decreasing of adult count when both are same economy mode
    When select travellers option
    And check by reducing adult count
    

  Scenario: is possible to reduce infant count along with decreasing of adult count when  adults are more than infants economy mode
    When select travellers option
    And observe infant count
    

  Scenario: is possible to reduce adult count along with decreasing of infant count when both are same economy mode
    When select travellers option
    And keep pressing - button beside infant option
    
    
   
    

  Scenario Outline: Select flight company name in Economy mode
    When select travellers option
    And select  any "<flight>"  company
    Examples: -
      | flight            |
      | All Airlines      |
      | Air India         |
      | Air India Express |
      | IndiGo            |
      | SpiceJet Ltd      |
      | Akasa Air         |
      | Alliance Air      |
      | Star Air          |
      | Vistara Airline   |
      
      
      
  
