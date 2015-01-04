# Can You Trust Your Tests?
(2015 Vilnius, Tadas Ščerbinskas & Vaidas Pilkauskas)

# Agenda
* Test code quality
* Mutation testing
* Mutant: mutation testing for Ruby

# Prod vs. Test code quality

# Who watches the watchmen?
//#### Quis custodiet ipsos custodes? (Juvenal)
//picture?

# Test Quality
* Readable
* Focused
* Concise
* Well named
* etc.

# What is code coverage?

# Types of code coverage
* Statement
* Branch
* And a lot of other :)

# Coverage tool for Ruby
simplecov

# Ruby Example for code coverage

# Line coverage report

# Branch coverage report

# Can you trust 100% coverage?
* Code coverage can show what is not tested, but not how good your tests are
* 100% code coverage for interpreted languages are like full compilation

# Mutation testing
A fault-based technique to assess and improve the quality of a test suite
Concept introduced in 1971 by Richard Lipton

# Mutation testing
Changes (mutates) your program code and expects your tests to fail. In other words all mutant is killed if you can observe a failing test.

# Your tests' effectiveness
Is measured by number of killed mutants by your test suite
Mutation testing does not test your code - it tests your tests

# Failing is a new passing


# Techniques
* Mutation injection
* Mutation types

# Mutation types
* Logic operators
* Statement removal

//add examples in ruby

# What if mutant survives
* simplify your code
* add additional tests
* TDD - write minimal amount of code to pass the test

# Challenges
* High computation cost - slow
* Equivalent mutants - false negatives

# Problems
* Endless loops
* Syntax errors   // (as far as I know, doesn't happen with mutant -T.)
* Segmentation faults

# Example of equal mutant

# Mutant
* Active project :)
* Good reporting

# Live demo

# Disadvantages
* Are there good enough tools
* Slow - cannot be part of TDD rhythm

