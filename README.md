# RateMyDrivingInstructor

This project is a full-stack web application designed to allow users to review and rate driving instructors. Inspired by the lack of accessible information on driving instructors and driving schools, this platform empowers learners to make informed choices based on real user experiences. By providing a dedicated space for reviews, we aim to shift from word-of-mouth recommendations to a more reliable, accessible system that highlights both positive and negative experiences.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Docker Commands](#docker-commands)

## Features

**As a non-registered user:**
- Search for:
  - Instructor
  - Driving school
  - View aggregated information published on the website (eg. number of reviews, number of reviewed instructors)

**As a registered user:**
- Rate instructors already on the website
- View comments and ratings

**As an admin:**
- Search by username
- Moderate user comments

## Tech Stack

- **Backend**: Java Spring Boot Web API
- **Database**: Spring Data JPA & PostgreSQL (PSQL)
- **Frontend**: React
- **Version Control**: Git & GitHub
- **Containerization**: Docker
- **Security**: Spring Security
- **Testing**: JUnit 5
- **Project Management**: GitHub Projects (Agile/Scrum)

## Prerequisites

- [Docker](https://www.docker.com/) and [Docker Compose](https://docs.docker.com/compose/) must be installed on your machine.

## Installation

1. Clone the project to your local machine:
    ```bash
    git clone git@github.com:CodecoolGlobal/el-proyecte-grande-sprint-1-java-judit-g.git
    cd el-proyecte-grande-sprint-1-java-judit-g
    ```

2. Create a .env file:
    ```env
    DB_PASSWORD=your_password
    DB_NAME=your_dbname
    ```

4. Build and start the application using Docker Compose:
    ```bash
    docker-compose up --build
    ```
   This command will build both backend and frontend services if needed and start them in detached mode.

5. Verify that both services are running:
   - **Backend**: Accessible at [http://localhost:8080](http://localhost:8080)
   - **Frontend**: Accessible at [http://localhost:5173](http://localhost:5173)

## Usage

- To start the entire application stack:
    ```bash
    docker-compose up
    ```
- To stop the services:
    ```bash
    docker-compose down
    ```
**Admin Access**: Certain features require administrator access, which you can obtain by logging in with the username `admin` and password `admin`.

## Docker Commands

Additional Docker commands to manage the application:

- **Rebuild images**: `docker-compose up --build`
- **View logs**: `docker-compose logs`
- **Stop containers**: `docker-compose down`
