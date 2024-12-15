Quiz System Project
Overview
The Quiz System is an interactive application that allows users to register, log in, take quizzes, and allows an admin to manage quiz questions. It uses a combination of data structures and algorithms to handle user management, quiz functionality, and performance optimization.

Features
User Registration & Login: Users can register with their name and password, then log in to start the quiz.
Admin Panel: Admins can add new quiz questions, options, and set the correct answers.
Quiz Functionality: Users can take a quiz with multiple questions and options. The system evaluates their performance and provides a grade.
Persistent Data Storage: User data is saved to a text file and loaded back when the application starts.
Data Structures Used
Linked Lists: For storing user names and passwords to handle user registration and login efficiently.
ArrayLists: For storing quiz questions, options, and correct answers, enabling efficient access and modification.
Algorithms Used
Login Validation: A search algorithm to validate user login credentials based on stored data.
Quiz Scoring: An algorithm to calculate and display the score after the quiz is completed, including grading based on performance.
Technology Stack
Java: The main programming language used for the implementation.
Text File Handling: Used to persist user data (names and passwords).
How to Use
Clone the repository to your local machine:

bash
Copy code
git clone https://github.com/yourusername/Quiz-System.git
Navigate to the project directory:

bash
Copy code
cd Quiz-System
Run the project using your preferred IDE or compile and run using the terminal.

When prompted, you can:

Press 'l' to log in.
Press 'r' to register a new user.
Press 'a' to access the admin panel (to add quiz questions).
Press 'e' to exit the application.
Contributing
Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes.
Commit your changes (git commit -am 'Add new feature').
Push to the branch (git push origin feature-branch).
Create a pull request.
