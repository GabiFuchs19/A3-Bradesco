# Use imagem oficial do OpenJDK 21
FROM openjdk:21-jdk-slim

# Diretório de trabalho no container
WORKDIR /app

# Copia o pom.xml e baixa as dependências primeiro (cache eficiente)
COPY pom.xml .

RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*
RUN mvn dependency:go-offline

# Copia o código fonte
COPY src ./src

# Empacota a aplicação
RUN mvn clean package -DskipTests

# Exponha a porta 8080
EXPOSE 8080

# Comando para rodar o jar gerado
CMD ["java", "-jar", "target/backend-1.0-SNAPSHOT.jar"]
