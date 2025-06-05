# A3-Bradesco
# Projeto Pix Blockchain - A3 Bradesco

![Badge em Desenvolvimento](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1-green)
![MongoDB](https://img.shields.io/badge/MongoDB-6.0-blue)

## 📌 Visão Geral
Sistema de rastreabilidade de comprovantes Pix via blockchain com mecanismos de prevenção a golpes financeiros, atendendo aos requisitos do documento técnico A3 Bradesco.
O projeto é construído utilizando arquitetura de microsserviços com Java + Spring Boot, MongoDB, Docker e Azure.

## 🛠️ Tecnologias Utilizadas
| Componente       | Tecnologia                  | Versão  |
|------------------|----------------------------|---------|
| Backend          | Spring Boot                | 3.1     |
| Banco de Dados   | MongoDB                    | 6.0     |
| Containerização  | Docker                     | 20.10+  |
| Cloud            | Azure                      | -       |
| Frontend         | HTML5 e CSS                | -       |
| Blockchain       |  (simulação)               | -       |
|       AI         |  (simulação)               | -       |

## ✅ Progresso Atual
- [x] Definição da arquitetura de microsserviços
- [x] Configuração inicial do repositório
- [x] Setup básico dos serviços principais
- [ ] Implementação completa dos microsserviços
- [ ] Integração com blockchain
- [ ] Deploy no Azure
- [ ] implementação AI
- [ ] Conectar Frontend com Backend
## 🔧 Pré-requisitos
- Java JDK 17+
- Docker 20.10+
- Docker Compose 2.0+
- MongoDB 6.0+ (ou via Docker)
- Conta Azure (para deploy)
## 🖥️ Telas Implementadas


| Tela | Arquivo | Descrição |
|------|---------|-----------|
| Login | `login.html` | Autenticação de usuários |
| Simulador de App | `app-simulator.html` | Interface app bradesco simulada |
| Transferência | `transferencia.html` | Fluxo completo de Pix |
| Comprovante | `comprovante.html` | Detalhes da transação |
| simulador | `simulador.html` | simulador |
##  Passos para Implementação Completa

##  Passos para Implementação Completa


### 1. Configuração do Ambiente
```bash
# Clonar repositório
git clone https://github.com/GabiFuchs19/A3-Bradesco.git
cd A3-Bradesco

# Instalar dependências (em cada microsserviço)
mvn clean install
