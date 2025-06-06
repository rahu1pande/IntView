# UserIntView - Spring Boot User Management System

A robust user management system built with Spring Boot, featuring secure authentication, email verification, and user profile management.

## Features

- User registration and authentication
- Email verification system
- Password reset functionality
- JWT-based security
- Account locking after failed attempts
- Profile image management
- Role-based access control

## Prerequisites

- Java 17 or higher
- Maven
- MySQL 8.0 or higher
- SMTP server (or Mailtrap for testing)

## Configuration

1. Clone the repository
2. Create a MySQL database named `my_db`
3. Configure your environment variables (see Environment Variables section)
4. Run the application

## Environment Variables

Create a `.env` file in the project root with the following variables:

```env
# Database Configuration
DB_URL=jdbc:mysql://localhost:3306/my_db
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password

# Email Configuration
MAIL_USERNAME=your_mail_username
MAIL_PASSWORD=your_mail_password

# JWT Configuration
JWT_SECRET=your_jwt_secret_key
```

## Running the Application

```bash
# Using Maven
./mvnw spring-boot:run

# Or using Java
java -jar target/userintview-0.0.1-SNAPSHOT.jar
```

## API Endpoints

### Authentication
- POST `/auth/register` - Register new user
- POST `/auth/login` - User login
- GET `/verify` - Verify email
- POST `/reset-password` - Reset password

### User Management
- GET `/dashboard` - User dashboard
- GET `/user/profile` - Get user profile
- PUT `/user/profile` - Update user profile

## Security

- Password encryption using BCrypt
- JWT token-based authentication
- Email verification
- Account locking after failed attempts
- CSRF protection
- XSS protection

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Your Name - [@yourtwitter](https://twitter.com/yourtwitter) - email@example.com

Project Link: [https://github.com/yourusername/UserIntView](https://github.com/yourusername/UserIntView) 