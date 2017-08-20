# Running the application

## Requirements
- Java 8 (tested on 1.8.0_144)
- Internet connection for Gradle to fetch artifacts

## How to run

### Displaying a fixed report

In order to display a report for a fixed set of data:

- run `gradlew fixed`
- alternatively use an IDE to run the `FixedDataRunner` class

### Displaying a randomized report

In order to display a report for a randomly generated set of data:

- run `gradlew random`
- alternatively use an IDE to run the `RandomDataRunner` class

### Running tests

- run `gradlew test`

Tests do not cover classes implemented for demo purposes (data generators, runners, etc)

# Design

## Classes

Class | Description
----- | -----------
`Instruction`, `InstructionType`, `Settlement`|Models for client instructions and settlements
`TradeStats`|Model for trade statistics that are described by the final report
`NextWorkingDayCalculator` and subclasses|Used to calculate the next working day
`NextWorkingDayCalculatorFactory`|Creates a correct `NextWorkingDayCalculator` based on given currency
`InstructionTradeAmountCalculator`|Calculates USD trade amount for an instruction
`InstructionSettler`|Turns instructions into settlements (with an actual settlement day and USD amount)
`TradeStatsCalculator`|Calculates trade statistics for a list of instructions
`ReportGenerator`|Generates text report from trade statistics
`DataGenerator` and subclasses|Generators of instructions used to showcase the application
`FixedDataRunner` and `RandomDataRunner`|Application's entry points. Executed by Gradle or with an IDE



## Design decisions and remarks

- "Units" was assumed to be an integer value
- There is no input data validation which would be necessary in a real-life project
- The assignment states:  *"Ranking of entities based on incoming and outgoing amount. Eg: If entity foo instructs the highest
  amount for a buy instruction, then foo is rank 1 for outgoing"*. 
  It is not explicitly stated that such a ranking should be created for every day (as it is for other parts of the report).
  Hence a single ranking for all transactions is created
  
# Dependencies

There are two test scope dependencies:

- JUnit
- Mockito

