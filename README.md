# Kindle 2.0 - Digital Library Management System (Minimized)# Kindle 2.0 - Digital Library Management System# Library Management System



## 📚 Overview

A simplified, fully-functional digital library management system with all features intact but minimal file count.

## Complete Full-Stack ApplicationA simple, fully functional library management system built with modern web technologies.

## 🗂️ Project Structure (Only 10 Files!)

```

jp/

├── index.html                              # Complete frontend (HTML+CSS+JS)### 🎯 **Application Overview**## 🚀 Technology Stack

├── start.bat                               # Quick start script

├── pom.xml                                # Maven configurationA comprehensive digital library management system built with:

├── src/main/

│   ├── resources/- **Backend**: Java Spring Boot + MySQL- **Frontend**: HTML5, CSS3 (DaisyUI + Tailwind CSS), JavaScript

│   │   ├── application.properties         # Database configuration

│   │   └── schema.sql                     # Database schema + sample data- **Frontend**: HTML5 + DaisyUI/Tailwind CSS + Vanilla JavaScript- **Backend**: Java Spring Boot

│   └── java/com/kindle/library/

│       ├── KindleLibraryApplication.java  # Spring Boot main class- **Features**: Complete CRUD operations for books, users, and borrowing system- **Database**: MySQL (with H2 for development)

│       ├── LibraryController.java         # Unified REST controller

│       ├── Book.java                      # Book entity- **Build Tool**: Maven

│       ├── User.java                      # User entity

│       ├── BorrowedBook.java             # Borrow record entity### 🛠 **Technology Stack**

│       └── Repositories.java             # All repositories in one file

```## 📁 Project Structure



## ✨ Features#### Backend

- **Complete Book Management**: Add, view, delete books with ISBN validation

- **User Management**: Register users with email validation- **Java 17+** - Programming language```

- **Borrow/Return System**: Full borrow/return functionality with due dates

- **Real-time Dashboard**: Statistics and recent activity- **Spring Boot 3.1.5** - Frameworkjp/

- **MySQL Database**: Persistent data storage with relationships

- **Local Storage Fallback**: Works offline if backend is unavailable- **Spring Data JPA** - Database operations├── frontend/           # Web application frontend

- **Responsive UI**: Modern design with DaisyUI components

- **MySQL 8.0** - Database│   ├── index.html     # Main HTML file with DaisyUI styling

## 🚀 Quick Start

- **Maven** - Build tool│   └── app.js         # JavaScript for API calls and interactions

### Prerequisites

- Java 17+├── backend/           # Spring Boot REST API

- Maven 3.6+

- MySQL 8.0+#### Frontend│   ├── src/



### Setup- **HTML5** - Structure│   │   └── main/

1. **Start MySQL** (ensure it's running on localhost:3306)

   - **DaisyUI + Tailwind CSS** - Styling framework│   │       ├── java/com/library/

2. **Configure Database** (if needed)

   - Default: username=root, password=root- **Vanilla JavaScript** - Interactivity│   │       │   ├── LibraryManagementApplication.java

   - Edit `src/main/resources/application.properties` if different

- **Fetch API** - Backend communication│   │       │   ├── model/        # Entity classes

3. **Run the Application**

   ```bash│   │       │   ├── repository/   # Data access layer

   # Option 1: Use the start script

   start.bat### 📋 **Prerequisites**│   │       │   └── controller/   # REST controllers

   

   # Option 2: Manual commands│   │       └── resources/

   mvn clean package -DskipTests

   java -jar target/kindle-library-1.0.0.jar1. **Java 17 or higher**│   │           ├── application.properties

   ```

   ```bash│   │           └── data.sql     # Sample data

4. **Open Frontend**

   - Open `index.html` in any web browser   java -version│   └── pom.xml        # Maven configuration

   - Login: username=admin, password=admin123

   ```├── database/          # SQL scripts

## 🔧 Configuration

│   ├── schema.sql     # Database schema

### Database Settings

Edit `src/main/resources/application.properties`:2. **Apache Maven**│   └── sample_data.sql # Sample data

```properties

spring.datasource.url=jdbc:mysql://localhost:3306/kindle_library?createDatabaseIfNotExist=true   ```bash└── README.md          # This file

spring.datasource.username=root

spring.datasource.password=root   mvn -version```

```

   ```

### API Endpoints

- Backend runs on: `http://localhost:8080/api`## ✨ Features

- All CORS enabled for frontend

- RESTful API with JSON responses3. **MySQL Server**



## 📋 How to Use   - Install MySQL 8.0+- **Book Management**: Add, view, search, and delete books



### 1. Books Management   - Create database user: `root` / `root`- **User Management**: Register and manage library users

- Navigate to "Books" section

- Add new books with title, author, ISBN, and genre   - Ensure MySQL is running on port 3306- **Borrowing System**: Borrow and return books with due date tracking

- Delete books (only if not currently borrowed)

- View availability status- **Real-time Statistics**: Dashboard with book and user statistics



### 2. User Management4. **Python 3.7+** (for frontend server)- **Responsive Design**: Works on desktop and mobile devices

- Go to "Users" section

- Register new users with name, email, and phone   ```bash- **Search Functionality**: Search books by title, author, or genre

- Delete users (only if no active borrows)

- View active borrow count   python --version



### 3. Borrowing System   ```## 🛠️ Setup Instructions

- Use "Borrow/Return" section

- Select user and available book

- Set borrow and due dates

- View currently borrowed books### 🚀 **Quick Start**### Prerequisites

- Quick return functionality



### 4. Return System

- Navigate to "Return Books"#### Option 1: Automatic Startup (Recommended)- Java 17 or higher

- Select borrowed book from dropdown

- Set return date1. Double-click `start-fullstack.bat`- Maven 3.6 or higher

- Book becomes available again

2. Wait for both servers to start- MySQL (optional - H2 is used by default)

### 5. Dashboard

- View total statistics3. Open browser to http://localhost:8000- Web browser (Chrome, Firefox, Safari, Edge)

- Monitor recent activity

- Real-time updates4. Login with: `admin` / `admin123`



## 🗄️ Database Schema### Quick Start (Development Mode)

The system automatically creates:

- `books` table: book information and availability#### Option 2: Manual Startup

- `users` table: user details with unique email

- `borrowed_books` table: borrow/return records1. **Clone/Download the project**



Sample data is inserted automatically on first run.1. **Start MySQL Database**   ```bash



## 🔒 Data Validation   ```bash   # Navigate to the project directory

- **Books**: ISBN uniqueness, required fields

- **Users**: Email validation and uniqueness   # Make sure MySQL is running   cd jp

- **Borrowing**: Availability checks, user limit (5 books max)

- **Returns**: Date validation, duplicate return prevention   mysql -u root -p   ```



## 🌐 Frontend Features   # Enter password: root

- **Single File**: Everything in one HTML file

- **Offline Capable**: Local storage fallback   ```2. **Start the Backend**

- **Real-time Sync**: Automatic backend synchronization

- **Responsive Design**: Works on desktop and mobile   ```bash

- **Modern UI**: Clean, intuitive interface

2. **Start Backend (Terminal 1)**   cd backend

## 🛠️ Technical Details

- **Backend**: Spring Boot 3.1.5 with JPA   ```bash   mvn spring-boot:run

- **Frontend**: Vanilla JavaScript with TailwindCSS & DaisyUI

- **Database**: MySQL with automatic schema creation   cd backend   ```

- **Build**: Maven with single JAR output

- **Architecture**: RESTful API with responsive SPA frontend   mvn spring-boot:run   The API will be available at `http://localhost:8080`



## 📝 API Summary   ```

| Endpoint | Method | Description |

|----------|--------|-------------|3. **Open the Frontend**

| `/api/books` | GET/POST/DELETE | Book operations |

| `/api/users` | GET/POST/DELETE | User operations |3. **Start Frontend (Terminal 2)**   - Open `frontend/index.html` in your web browser

| `/api/borrows` | GET/POST | Borrow operations |

| `/api/borrows/{id}/return` | PUT | Return book |   ```bash   - Or serve it using a simple HTTP server:

| `/api/dashboard/stats` | GET | Dashboard statistics |

   cd ..   ```bash

## 🚨 Troubleshooting

1. **Database Connection**: Ensure MySQL is running and credentials are correct   python server.py   cd frontend

2. **Port Conflicts**: Backend uses port 8080, ensure it's available

3. **Frontend Offline**: The app works with local storage if backend is unavailable   ```   # Using Python

4. **Build Issues**: Ensure Java 17+ and Maven are properly installed

   python -m http.server 3000

## 🎯 What Was Minimized

- **Files Reduced**: From 40+ files to just 10 essential files4. **Access Application**   # Or using Node.js

- **Code Merged**: All controllers combined into one

- **Entities Simplified**: Removed unnecessary annotations and complexity   - Frontend: http://localhost:8000   npx serve .

- **Frontend Unified**: Single HTML file with embedded CSS and JavaScript

- **Removed**: Log files, batch files, backup files, duplicate code, unused directories   - Backend API: http://localhost:8080/api   ```



**All functionality preserved** - this is a complete, production-ready library management system in minimal files!

### 📊 **Database Setup**4. **Access the Application**

   - Frontend: `http://localhost:3000` (or just open index.html)

The application will automatically:   - Backend API: `http://localhost:8080/api`

- Create database `kindle_library` if it doesn't exist   - H2 Database Console: `http://localhost:8080/h2-console`

- Create all required tables

- Insert sample data (books, users, admin account)### Production Setup with MySQL



Manual setup (optional):1. **Install MySQL** and create a database:

```sql   ```sql

mysql -u root -p < backend/src/main/resources/schema.sql   CREATE DATABASE library_management;

```   ```



### 🔐 **Authentication**2. **Update Backend Configuration**

   Edit `backend/src/main/resources/application.properties`:

**Default Admin Account:**   ```properties

- Username: `admin`   spring.datasource.url=jdbc:mysql://localhost:3306/library_management

- Password: `admin123`   spring.datasource.username=your_username

   spring.datasource.password=your_password

### 🎨 **Features**   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

#### Dashboard   ```

- Real-time statistics

- Recent activity feed3. **Run Database Scripts**

- Quick overview of library status   ```bash

   mysql -u your_username -p library_management < database/schema.sql

#### Books Management   mysql -u your_username -p library_management < database/sample_data.sql

- Add new books (Title, Author, ISBN, Genre)   ```

- View all books with availability status

- Delete books (only if not borrowed)4. **Build and Run**

- Automatic availability tracking   ```bash

   cd backend

#### Users Management   mvn clean package

- Register new users (Name, Email, Phone)   java -jar target/library-management-0.0.1-SNAPSHOT.jar

- View user list with active borrow counts   ```

- Delete users (only if no active borrows)

- Email validation and duplicate prevention## 📚 API Endpoints



#### Borrowing System### Books

- Borrow books to users- `GET /api/books` - Get all books

- Automatic due date calculation (14 days)- `GET /api/books/{id}` - Get book by ID

- Real-time availability updates- `GET /api/books/available` - Get available books

- Borrow limit enforcement (5 books per user)- `GET /api/books/search?query={term}` - Search books

- `POST /api/books` - Add new book

#### Return System- `PUT /api/books/{id}` - Update book

- Search borrowed books- `DELETE /api/books/{id}` - Delete book

- Return with custom date

- Overdue book tracking### Users

- Return date validation- `GET /api/users` - Get all users

- `GET /api/users/{id}` - Get user by ID

### 🌐 **API Endpoints**- `POST /api/users` - Add new user

- `PUT /api/users/{id}` - Update user

#### Books- `DELETE /api/users/{id}` - Delete user

- `GET /api/books` - Get all books

- `GET /api/books/available` - Get available books### Borrowing

- `POST /api/books` - Create new book- `GET /api/borrowed` - Get all borrowed books

- `PUT /api/books/{id}` - Update book- `POST /api/borrow` - Borrow a book

- `DELETE /api/books/{id}` - Delete book- `PUT /api/return/{borrowedId}` - Return a book



#### Users## 🎯 Usage Guide

- `GET /api/users` - Get all users

- `POST /api/users` - Create new user### Managing Books

- `PUT /api/users/{id}` - Update user1. Navigate to the "Books" section

- `DELETE /api/users/{id}` - Delete user2. View all books in the collection

3. Use the search bar to find specific books

#### Borrowing4. Click "Add New Book" to add books to the collection

- `GET /api/borrows/active` - Get active borrows5. Delete books using the delete button on each book card

- `POST /api/borrows` - Borrow a book

- `PUT /api/borrows/{id}/return` - Return a book### Managing Users

- `GET /api/borrows/search?query=` - Search borrows1. Go to the "Users" section

2. View all registered users

#### Dashboard3. Add new users with the "Add New User" button

- `GET /api/dashboard/stats` - Get statistics4. Delete users as needed

- `GET /api/dashboard/health` - Health check

### Borrowing and Returning Books

### 🔧 **Configuration**1. Navigate to "Borrow/Return" section

2. **To borrow a book**:

#### Backend Configuration (`backend/src/main/resources/application.properties`)   - Select a user from the dropdown

```properties   - Select an available book

# Database   - Click "Borrow Book"

spring.datasource.url=jdbc:mysql://localhost:3306/kindle_library3. **To return a book**:

spring.datasource.username=root   - Select the borrowed book from the return dropdown

spring.datasource.password=root   - Click "Return Book"

4. View all currently borrowed books in the table below

# Server

server.port=8080## 🔧 Configuration

server.servlet.context-path=/api

### Database Configuration

# CORS (already configured for frontend)The application uses H2 in-memory database by default for easy setup. To use MySQL:

spring.web.cors.allowed-origins=http://localhost:8000

```1. Uncomment MySQL dependency in `pom.xml`

2. Update `application.properties` with MySQL configuration

#### Frontend Configuration (`frontend/app.js`)3. Run the SQL scripts in the `database/` folder

```javascript

// API Base URL### CORS Configuration

const API_BASE_URL = 'http://localhost:8080/api';CORS is enabled for all origins in development. For production, update the `@CrossOrigin` annotations in the controllers.

```

## 🚨 Troubleshooting

### 📁 **Project Structure**

```### Common Issues

jp/

├── backend/                    # Java Spring Boot backend1. **Port 8080 already in use**

│   ├── src/main/java/com/kindle/library/   - Change the port in `application.properties`: `server.port=8081`

│   │   ├── entity/            # JPA entities

│   │   ├── repository/        # Data repositories2. **Frontend can't connect to backend**

│   │   ├── controller/        # REST controllers   - Ensure backend is running on `http://localhost:8080`

│   │   └── KindleLibraryApplication.java   - Check browser console for CORS errors

│   ├── src/main/resources/   - Verify API_BASE_URL in `app.js`

│   │   ├── application.properties

│   │   └── schema.sql         # Database schema3. **Database connection issues**

│   └── pom.xml               # Maven configuration   - Check database credentials in `application.properties`

├── frontend/                  # Frontend application   - Ensure MySQL is running (if using MySQL)

│   ├── index.html            # Main HTML file   - For H2, access console at `/h2-console`

│   ├── app.js               # JavaScript logic

│   └── logo.png             # Logo image### Development Mode

├── server.py                # Frontend server- Backend automatically reloads on code changes with Spring Boot DevTools

├── start-fullstack.bat     # Startup script- Frontend requires manual browser refresh

└── README.md               # This file- H2 database resets on application restart (use MySQL for persistence)

```

## 📄 License

### 🐛 **Troubleshooting**

This project is open source and available under the MIT License.

#### Backend won't start

- Check Java version: `java -version`## 🤝 Contributing

- Check Maven: `mvn -version`

- Verify MySQL is running: `mysql -u root -p`1. Fork the repository

2. Create a feature branch

#### Frontend won't connect to backend3. Make your changes

- Ensure backend is running on port 80804. Test thoroughly

- Check browser console for errors5. Submit a pull request

- Verify CORS configuration

## 📞 Support

#### Database connection issues

- Check MySQL credentials (root/root)For issues and questions:

- Verify MySQL is running on port 3306- Check the troubleshooting section above

- Check firewall settings- Review the API documentation

- Check application logs for detailed error messages
#### Port conflicts
- Backend uses port 8080
- Frontend uses port 8000
- Change ports in configuration if needed

### 🚀 **Production Deployment**

#### Build for Production
```bash
# Backend
cd backend
mvn clean package

# Frontend
# Copy frontend/ folder to web server
```

#### Docker Deployment (Optional)
```dockerfile
# Create Dockerfile for backend
FROM openjdk:17-jdk-slim
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### 🎯 **Future Enhancements**

- [ ] JWT Authentication with Spring Security
- [ ] User roles and permissions
- [ ] Email notifications for overdue books
- [ ] Advanced search and filtering
- [ ] Book reservation system
- [ ] Report generation
- [ ] Mobile responsive improvements

### 📞 **Support**

For issues and questions:
1. Check the troubleshooting section
2. Review console logs for errors
3. Verify all prerequisites are installed
4. Ensure both servers are running

### 🏆 **Success Indicators**

You'll know everything is working when:
1. ✅ Backend starts without errors
2. ✅ Frontend connects to backend successfully
3. ✅ You can login with admin/admin123
4. ✅ Dashboard shows statistics
5. ✅ You can add/view books and users
6. ✅ Borrowing and returning works

---

**Kindle 2.0 - Digital Library Management System**  
*Complete full-stack solution for modern library management*