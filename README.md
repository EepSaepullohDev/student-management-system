# Student Management System

This is a simple student management system built using Spring Boot, PostgreSQL, and Lombok. It provides basic CRUD operations for managing student data.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 8 or higher
- Maven
- PostgreSQL

### Installing

1. Clone the repository
```
git clone https://github.com/yourusername/student-management-system.git
```
2. Navigate to the project directory
```
cd student-management-system
```
3. Install dependencies
```
mvn install
```
4. Run the application
```
mvn spring-boot:run
```
The application will start running at `http://localhost:8080`.

## Usage

The application exposes the following endpoints:

- `GET /students`: Fetch all students
- `GET /students/{id}`: Fetch a single student by id
- `POST /students`: Create a new student
- `PUT /students/{id}`: Update an existing student
- `DELETE /students/{id}`: Delete a student

## Running the tests

To run the tests, use the following command:

```
mvn test
```

## Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
- [PostgreSQL](https://www.postgresql.org/) - The database used
- [Lombok](https://projectlombok.org/) - A java library to reduce boilerplate code

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/yourusername/your-repo/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Authors

- **Your Name** - *Initial work* - [YourUsername](https://github.com/yourusername)

See also the list of [contributors](https://github.com/yourusername/your-repo/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

- Hat tip to anyone whose code was used
- Inspiration
- etc