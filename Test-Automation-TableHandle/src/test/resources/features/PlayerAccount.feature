Feature: Verify PlayerAccount and PlayerProfile Name
@verifyPlayerAccount
Scenario: Verify PlayerAccount and PlayerProfile Name based on Player Profile Name
Given User navigates to Game Portal Page
And User accepts all cookies and age questions
And User logs in
When User clicks on Avatar or user's credentials
  And User clicks on Player Account Tab
Then User's name on the Player Account should be correct
And User clicks on Player's Profile
And The user's name and the name in Player Profile should be equal