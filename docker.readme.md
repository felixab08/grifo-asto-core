# Read Me First
Vamos a eliminar solo la imagen de java

```bash
# 1. Detiene el contenedor
docker stop java_app

# 2. elimina uno contenedor
docker rm java_app

# 3. elimina imagen
docker rmi grifo-java-app:1.0.0

# 4. elimina imagen
.\mvnw.cmd clean test-compile
./mvnw clean package -DskipTests  

# 5. reconstruya las imágenes antes de iniciar los servicios
docker-compose up -d
```
