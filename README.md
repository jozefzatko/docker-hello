# Java Spring + Docker hello-world example
Simple Spring boot application publishing REST interface returning local IP address.
Ready to be built as [Docker](https://www.docker.com/) container

Application is published here: https://hub.docker.com/r/jozefzatko/docker-hello-example

### How to build a Docker container?
`docker build -t docker-hello-example .`

### How to run it?
`docker run -p 8080:8080 docker-hello-example`

### How to test it?
http://localhost:8080/