# Web Application: Student Wellness Management System - Milestone 1

## Overview 📋
Java web application for student login and registration, built with JSP, Servlets, and PostgreSQL.

## Structure 🗄️
- `src/`: Java backend (servlets, JDBC)
- `web/`: JSP frontend
- `utils/DBConnection.java`: PostgreSQL connection
- `DbBackup.sql`: PostgreSQL database backup (TAR format)

## Tech Stack 🤖
- `Java`: JSP, Servlets
- `HTML/CSS` (with Tailwind CSS)
- `PostgreSQL`
- `JDBC`
- `GitHub`

## Tailwind CSS 🎨
The frontend is styled using [Tailwind CSS](https://tailwindcss.com/), a utility-first CSS framework that makes UI development faster and more consistent.

## Database Restoration Instructions 🧩

To restore the `DbBackup.sql` file using **pgAdmin**:

1. **Open pgAdmin** and connect to your PostgreSQL server.
2. **Create a new database**:
   - Right-click `Databases` > `Create` > `Database...`
   - Name it something like `StudentWellness` (or any preferred name).
3. After the DB is created, **right-click the new database** and choose `Restore...`.
4. In the **Restore** dialog:
   - **Format**: Select `Tar`.
   - **Filename**: Click the folder icon and select `DbBackup.sql` from your local system.
5. Click **Restore**.
6. Wait for the process to complete — your database will now be populated with the required schema and data.


## Team Members and Roles 📣
- `Martinus Christoffel Wolmarans (577963)`: JSP Pages and Dashboard
- `Storm Tarran (600995)`: Servlets
- `Willem Paton (577287)`: Validation and Security
- `Matt Takawira (600791)`: PostgreSQL and JDBC
