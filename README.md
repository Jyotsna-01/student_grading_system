# Student GPA Calculator

## Overview
This Java project reads student data from a CSV file, calculates their grades and GPA based on their course marks, and saves the results to an output text file. The system uses object-oriented programming principles, including inheritance, to differentiate between general students and undergraduate students.

## Features
- Reads student data from a CSV file.
- Calculates grades based on predefined criteria.
- Computes the Grade Point Average (GPA) for each student.
- Writes the computed GPA and grades to an output text file.
- Implements object-oriented design with inheritance.

## File Structure
```
├── Main.java                 # Main entry point of the program
├── students.csv              # Sample input dataset (not included, must be provided)
├── gpa_results.txt           # Output file where GPA results are stored
└── README.md                 # Project documentation
```

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- A CSV file containing student data in the format:
  ```
  Name,StudentID,Course,Marks
  John Doe,101,Math,85
  Jane Smith,102,Science,92
  ```

## How to Run
### 1. Compile the Java program:
```sh
javac Main.java
```

### 2. Run the program with default file paths:
```sh
java Main
```

## Grade Calculation Criteria
| Marks Range | Grade |
|------------|-------|
| 90 - 100   | A     |
| 80 - 89    | B     |
| 70 - 79    | C     |
| 60 - 69    | D     |
| Below 60   | F     |

## GPA Calculation
The GPA is computed based on the following grade-to-point conversion:
| Grade | Point Value |
|-------|------------|
| A     | 4.0        |
| B     | 3.0        |
| C     | 2.0        |
| D     | 1.0        |
| F     | 0.0        |

## Error Handling
- If the CSV file has missing or incorrectly formatted data, the program will skip those entries.
- If an error occurs while reading or writing files, an appropriate error message is displayed.

## Output Example
After execution, the output file (`gpa_results.txt`) will contain student information like:
```
Student: John Doe (ID: 101)
GPA: 3.00
Grades: {Math=B}

Student: Jane Smith (ID: 102)
GPA: 4.00
Grades: {Science=A}
```

## License
This project is open-source and free to use under the MIT License.

## Author
Jyotsna

