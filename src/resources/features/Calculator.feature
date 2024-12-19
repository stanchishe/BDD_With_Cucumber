Feature: Simple calculator
  As a Student
  I want to be able to do simple math
  To pass my tests

  Scenario: 1. Add two integers
    Given the numbers 5 and 11
    When a sum of them is produced
    Then the result should be 16

  Scenario: 2. Subtract two integers
    Given the numbers 5 and 11
    When a result of the subtraction is produced
    Then the subtraction result should be 6
