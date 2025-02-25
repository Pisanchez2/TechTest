# Tech Test

## 📌 Requisitos

Antes de iniciar, asegúrate de tener instalado lo siguiente en tu sistema:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- Git

---

## 🚀 Instalación y Despliegue

### 1️⃣ Clonar el Repositorio
```bash
git clone https://github.com/Pisanchez2/TechTest.git
cd TechTest
```

### 2️⃣ Configurar Variables de Entorno
Crea un archivo `.env` en la raíz del proyecto:

```bash
touch .env
nano .env
```

Agrega las siguientes variables y guarda:
```env
# App Configuration
APP_NAME=TechTest

# MySQL Database Configuration
SPRING_DATASOURCE_DOCKER_URL=jdbc:mysql://mysql_db:3306/<DBNAME>?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/<DBNAME>?useSSL=false&serverTimezone=UTC
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=
```

### 3️⃣ Construir la Imagen Docker de la Aplicación (Si Necesario)
```bash
docker build -t TechTest .
```

### 4️⃣ Levantar los Contenedores con Docker Compose
```bash
docker compose up -d
```

Este comando:
- Levanta un contenedor MySQL con la base de datos `techTestDB`
- Inicia la aplicación Spring Boot en otro contenedor

---

## ✅ Verificaciones Post-Despliegue

### Comprobar que los Contenedores Están Corriendo
```bash
docker ps
```

### Ver Logs de los Contenedores
```bash
docker logs mysql_db
docker logs spring_app
```

### Probar Conexión a la Base de Datos
```bash
docker exec -it mysql_db mysql -uuser -ppassword -e "SHOW DATABASES; USE techTestDB; SHOW TABLES;"
```

### Acceder a la Aplicación desde el Navegador
```plaintext
http://localhost:8080
```

---

## 🔧 Detener y Eliminar Contenedores

Para detener los contenedores sin eliminar volúmenes:
```bash
docker compose down
```

Para eliminar los volúmenes (datos persistentes de MySQL):
```bash
docker compose down -v
```

---

## 📝 Notas
- Si `init.sql` no se ejecuta en la primera ejecución, eliminar los volúmenes y volver a iniciar:
  ```bash
  docker compose down -v
  docker compose up -d
  ```
- Usa `docker-compose.override.yml` para configuraciones personalizadas sin modificar el `docker-compose.yml` principal.
