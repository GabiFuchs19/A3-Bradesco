# Etapa 1: build da aplicação com Maven
FROM maven:3.9.4-eclipse-temurin-21 as builder

WORKDIR /app

# Copia os arquivos necessários
COPY pom.xml .
COPY src ./src

# Empacota a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: imagem final apenas com o jar
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copia o jar gerado na etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Exponha a porta
EXPOSE 8080

# Executa a aplicação
CMD ["java", "-jar", "app.jar"]
