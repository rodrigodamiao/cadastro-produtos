# 🛠️ Spring Boot - CRUD de Produtos

Este é um projeto simples criado com o objetivo de estudar e praticar os principais conceitos do **Spring Boot** no desenvolvimento de APIs REST, com integração ao banco de dados **PostgreSQL**.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Postman (para testes)
- Maven

---

## 📚 O que foi praticado neste projeto

- ✅ Criação de uma API RESTful completa (CRUD de produtos)
- ✅ Integração com banco de dados PostgreSQL usando Spring Data JPA
- ✅ Estruturação de projeto com camadas: `Controller`, `Service`, `Repository`, `Exception`
- ✅ Boas práticas de código e separação de responsabilidades
- ✅ Validação de dados com Bean Validation
- ✅ Tratamento de exceções com `@ControllerAdvice`
- ✅ Criação de mensagens de erro personalizadas com `RestErrorMessage`
- ✅ Formatação de datas com `JacksonConfig` e `LocalDateTime`
- ✅ Uso de `@Configuration` para configurar o `ObjectMapper`
- ✅ Testes com Postman

---

## 📦 Funcionalidades da API

- `GET /produtos` - Lista todos os produtos
- `GET /produtos/{id}` - Busca produto por ID
- `POST /produtos` - Adiciona um novo produto
- `PUT /produtos/{id}` - Atualiza um produto existente
- `DELETE /produtos/{id}` - Deleta um produto com mensagem personalizada

---

## 💡 Observações

- Os endpoints foram testados com **Postman**, e retornam mensagens claras em caso de erro.
- As datas são formatadas no padrão `dd/MM/yyyy HH:mm:ss` através de configuração global do Jackson.
- O projeto pode ser facilmente expandido para outros domínios além de "Produto".

---

## 📷 Exemplo de resposta de erro

```json
{
  "message": "Produto com id 99 não encontrado.",
  "status": 404,
  "timestamp": "06/06/2025 16:04:32"
}
```
