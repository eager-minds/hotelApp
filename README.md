# Hotel App

## Table of contents
- [General info](#general-info)
- [Domains](#domains)
- [Methodologies](#methodologies)
- [Technologies](#technologies)
- [Screenshots](#screenshots)
- [Setup](#setup)
- [Usage](#usage)
- [Features](#features)
- [Project Status](#project-status)
- [To Do](#to-do)
- [About Owner](#about-owner)
- [License](#license)

### General info
Hotel application to get availability.

![Availability Domain](archimate/images/availabilitySearchView.bmp)

### Domains
- availability

### Methodologies
- Contract first
- Api first
- BDD
- TDD

### Technologies
Project is created with technology:version
- OpenApi:3.0.0
- Docker-compose:3.8
- Kafka:
- Schema-Registry:
- MongoDB:
- Java:17
- Spring:
- Archimate

### Screenshots
...

### Setup
`runEnv.sh` script:
- Run docker environment with containers below:
  - Kafka
  - Schema-Registry
  - MongoDB
```
$ ./runEnv.sh
```

`registry.sh` script:
- generates avros from idls
- set topics compatibility to `FULL_TRANSITIVE`
- register topics on schema-registry

`stopEnv.sh` script:
- Stops docker environment
```
$ ./stopEnv.sh
```

### Modules
- [node-js-swagger-mock-server](nodejs-swagger-mock-server) -> [README.md](nodejs-swagger-mock-server/README.md)

### Usage
To run Swagger Mock Server see [README.md](nodejs-swagger-mock-server/README.md).

You can also import [OpenApi file](api/HotelAvailability-1.0.0-swagger.yaml) to postman API.


### Features
- save searches
- retrieve searches by id
- get count of similar searches

### Project Status
**In Progress**

### To Do
1. Acceptance Criteria
2. BDD Gherkin Features
3. module search-post-api
4. module search-get-api
5. module search-sink-persist
6. performance charts

### About Owner
Created by:
- [@javierddn](https://www.linkedin.com/in/javierdediegonavarro)
  - Github: https://github.com/javierddn
  - LinkedIn: https://www.linkedin.com/in/javierdediegonavarro
  - DockerHub: https://hub.docker.com/u/javierddn
  - Bitbucket: https://bitbucket.org/javierddn
  - Gitlab: https://gitlab.com/javierddn
  - TravisCI: https://app.travis-ci.com/github/javierddn
  - CircleCI: https://app.circleci.com/pipelines/github/javierddn

- [@eagerminds](https://www.linkedin.com/company/eager-minds)
  - Github: https://github.com/eager-minds
  - LinkedIn: https://www.linkedin.com/company/eager-minds
  - DockerHub: https://hub.docker.com/u/eagerminds
  - Bitbucket: https://bitbucket.org/eagerminds
  - TravisCI: https://app.travis-ci.com/github/eagerminds-javier
  - CircleCI: https://app.circleci.com/pipelines/github/eagerminds-javier

📩 Feel free to contact me! 📩

## [License](LICENSE)

### NO_LICENSE

This project and code can not be used to commercial purposes.<br>
Any type of use, modification or distribution must be accompanied by permission from the author
and always be named as owner.