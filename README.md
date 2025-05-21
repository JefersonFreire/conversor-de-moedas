
# 💱 Conversor de Moedas

Projeto Java que realiza a conversão de moedas utilizando a [ExchangeRate API](https://www.exchangerate-api.com/). O sistema permite ao usuário escolher entre diferentes pares de moedas e visualizar o valor convertido com base na taxa de câmbio atual.

---

## 🧰 Tecnologias Utilizadas

- Java 21
- API HTTP: `java.net.http.HttpClient`
- Biblioteca GSON para parsing JSON
- IDE: IntelliJ IDEA
- Terminal para interação com o usuário

---

## 📦 Como Executar

### 1. Clonar o repositório

```bash
git clone https://github.com/JefersonFreire/conversor-de-moedas
cd conversor-moedas
```

### 2. Obter a chave da API

Crie uma conta gratuita no site [ExchangeRate API](https://www.exchangerate-api.com/), e obtenha sua chave (API Key).

### 3. Configurar a variável de ambiente `API_KEY`

#### No IntelliJ IDEA:

1. Vá em: **Run > Edit Configurations**
2. Adicione a variável em **Environment Variables**:

```
API_KEY=SUA_CHAVE_AQUI
```

---

## ▶️ Como Usar

Execute a classe `Main.java` e escolha uma das opções do menu:

```text
------------------------------------------------------------
Conversor de Moedas
------------------------------------------------------------
1) Dólar ==> Real
2) Real ==> Dólar
3) Dólar Canadense ==> Real
4) Real ==> Peso Argentino
5) Real ==> Dólar Australiano
6) Real ==> Euro
7) Sair
------------------------------------------------------------
```

Você será solicitado a digitar o valor desejado para conversão. O resultado será exibido no terminal.

---

## ✅ Funcionalidades

- [x] Menu interativo com múltiplas opções de conversão
- [x] Requisições HTTPS para taxa de câmbio em tempo real
- [x] Conversão precisa com até 2 casas decimais
- [x] Validação de entradas do usuário
- [x] Tratamento de erros e exceções
- [x] Uso de variáveis de ambiente para proteger a chave da API

---

## 📂 Estrutura do Projeto

```
src/
└── br/com/jeferson/
    ├── Currency.java              # Modelo de dados para os valores da API
    ├── CurrencyJsonParser.java    # Faz o parsing do JSON para o objeto Currency
    ├── ExchangeApiClient.java     # Responsável por fazer a chamada HTTP à API
    ├── ExchangeApiService.java    # Camada de serviço que organiza a conversão
    └── Main.java                  # Interface com o usuário (console)
```

---

## ⚠️ Observações

- A API gratuita pode ter limites de requisições por hora.
- É importante **NÃO expor sua chave da API** em repositórios públicos. Use sempre variáveis de ambiente.

---

## 👨‍💻 Autor

**Jeferson Freire**  
Desenvolvedor em transição de carreira com sólida experiência em logística e agora focado em aplicações Java.
