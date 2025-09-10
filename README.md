# API BOOKSHOP IN JAVA USING SPRING FRAMEWORK

## The API include the necessary dependencys to run a project in Spring

## The project include:

* Models
* Repository
* Service
* Controller
* BD MySQL

## Endpoint

### The All endpoint start `http://localhost:8080`

---

#### Libros

<span style="color: #88DC65">Methods GET</span>

`http://localhost:8080/api/libros` 

### Get all the books

`http://localhost:8080/api/libros/{id}` 

### Get the book by Id

`http://localhost:8080/api/libros/buscar/autor/{autor}` 

### Get all the books by author

`http://localhost:8080/api/libros/buscar/genero/{genero}` 

### Get all the books by genero

`http://localhost:8080/api/libros/buscar/anio/{anioDesde}/{anioHasta}` 

### Get all the books by Date

<span style="color: #FFFF00">Methods POST</span>

`http://localhost:8080/api/libros` 

### Add a new book

<span style="color: #87CEFA">Methods PUT</span>

`http://localhost:8080/api/libros/{id}` 

### Modify a book

<span style="color: #FE0000">Methods DELETE</span>

`http://localhost:8080/api/libros/{id}` 

### Delete a book

---

#### Usuario

<span style="color: #88DC65">Methods GET</span>

`http://localhost:8080/api/usuario` 

### Get all the users

`http://localhost:8080/api/usuario/{id}` 

### Get the user by Id

<span style="color: #FFFF00">Methods POST</span>

`http://localhost:8080/api/usuario` 

### Add a new user

<span style="color: #87CEFA">Methods PUT</span>

`http://localhost:8080/api/usuario/{id}` 

### Modify an user

<span style="color: #FE0000">Methods DELETE</span>

`http://localhost:8080/api/usuario/{id}` 

### Delete an user

---

#### Gestion Prestamo

<span style="color: #88DC65">Methods GET</span>

`http://localhost:8080/api/gestionPrestamos` 

### Get all the loan managements

`http://localhost:8080/api/gestionPrestamos/filtrarPrestamos` 

### Get the filters borrowed

`http://localhost:8080/api/gestionPrestamos/buscarPrestamosByID/{id}` 

### Get the filters by Id

`http://localhost:8080/api/gestionPrestamos/filtrarLibrosNoDevueltos` 

### Get the filters not borrowed

<span style="color: #FFFF00">Methods POST</span>

`http://localhost:8080/api/gestionPrestamos/actualizar` 

### Update the borrowed