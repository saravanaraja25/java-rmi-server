
# Presidio Points - Backend

Welcome to the Presidio Points - Backend Repository. Presidio Points is a project to engage people to participate in the initiatives within the organisation.

## Table of Contents

* [Technologies Used] (#technologies-used)
* [Project Local Setup] (#local-setup)
* [Migration Commands] (#migration-commands)
* [Deployed Environments] (#deployed-environments)
* [Jira / Confluence Links] (#jira-confluence-links)

## Technologies Used

* Serverless Framework with Node
* MySQL RDS Database
* Sequelize ORM

## Project Local Setup

* Clone the Repository
* Install the Serverless Framework Globally

```bash
npm install -g serverless
```

* Install Sequelize Globally

```bash
npm install -g sequelize 
```

* Goto the project root folder and install node modules

```bash
npm install
```

* Create a file config/config.json from config/config.example.json and update the DB credenitals

* Create a file .env from .env.example and update the values

* Perform the sequelize migrations to update the DB Schema in your local database. [Click here for Steps] (#migration-command)

