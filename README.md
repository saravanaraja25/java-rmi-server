# Presidio Points - Backend

Welcome to the Presidio Points - Backend Repository. Presidio Points is a project to engage people to participate in the initiatives within the organisation.

## Table of Contents

- [Presidio Points - Backend](#presidio-points---backend)
  - [Table of Contents](#table-of-contents)
  - [Technologies Used](#technologies-used)
  - [Project Local Setup](#project-local-setup)
  - [Migration Commands](#migration-commands)
  - [Deployed Environments](#deployed-environments)
  - [Jira / Confluence Links](#jira--confluence-links)
  - [Infra Deployment Steps](#infra-deployment-steps)

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

* Install Sequelize CLI Globally

```bash
npm install -g sequelize-cli
```

* Goto the project root folder and install node modules

```bash
npm install
```

* Create a file config/config.json from config/config.example.json and update the DB credenitals

* Create a file .env from .env.example and update the values

* Perform the sequelize migrations to update the DB Schema in your local database. [_Click here for steps_](#migration-commands)

* Then Run the API locally using the commands

```bash
serverless offline
```

## Migration Commands

Run the Migration to apply the DB Schema to the Database from migrations

```bash
npx:sequelize-cli db:migrate
```

Refer the documentation if you want to update the schema using migration [_Click here_](https://dev.to/nedsoft/add-new-fields-to-existing-sequelize-migration-3527)

## Deployed Environments

Frontend Deployed Dev URL

```bash
https://presidiopoints.dev.app.presidio.com/
```

Backend API Endpoints Base URL

```bash
https://ef05xj0om5.execute-api.us-west-2.amazonaws.com/dev
```

## Jira / Confluence Links

Jira Board [_Click here_](https://codaglobal.atlassian.net/jira/software/c/projects/PP/boards/589)

Confluence Page [_Click here_](https://codaglobal.atlassian.net/wiki/spaces/PP1/pages/5216305362/Project+Team+and+Links)

## Infra Deployment Steps

For First Time Deployment We have to deploy the application from local.

To deploy the application. Enter the following command:

```bash
serverless deploy --region < region > --stage < dev/qa/prod >
```

While Deploying from local for the first time steps to be remebered.
* Command the line inside **serverless.yml**
  
```bash
package:
    individually:true
```

* Also command the environment variables that takes values from secrets-manager in **serverless.yml** file, since secret manager was not created at the first deployment.

After deployment completed infra will be created and code commit repo also created.

Push the frontend and backend code to the respective repositories in the **dev** branch and the codepipeline will deploy the application.

* Frontend URL can be taken from cloudfront

* Backend API URL can be taken from API Gateway
