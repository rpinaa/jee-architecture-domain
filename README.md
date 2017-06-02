# jee-architecture-domain
JEE 7 non-blocking I/O Architecture, using EJB 3.2, JPA 2.0 and Domain Layer

## Requirements

- JDK 1.8
- Apache Maven 3.x

## Stack

- JSE 8
- EJB 3.x
- JPA 2.x
- Lombok

## Contribution guide

### Remotes

The **remotes** follow the convention:

- _**origin**_: fork in the account of the developer

- _**upstream**_: main repository

### Building

Set the project before start:

```sh
$ cd jee-architecture-domain
```

For local environment:

```sh
$ mvn clean -P local
```

For development environment:

```sh
$ mvn clean -P development
```

For staging environment:

```sh
$ mvn clean -P staging
```

For production environment:

```sh
$ mvn clean -P production
```

## License

MIT

**Free Software, Hell Yeah!**