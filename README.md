# 💱 Conversor de Moedas Multilíngue com Interface Gráfica (Java + Swing)

**🇧🇷 Português · 🇺🇸 English · 🇪🇸 Español**

---

## 🇧🇷 Sobre o Projeto

Este é um conversor de moedas em **Java** com interface gráfica construída com **Swing**, que obtém taxas de câmbio em tempo real via **ExchangeRate API**. Ele oferece suporte a três idiomas e várias moedas da América do Sul.

## 🇺🇸 About the Project

This is a **Java** currency converter with a graphical interface using **Swing**, which retrieves real-time exchange rates from the **ExchangeRate API**. It supports three languages and several South American currencies.

## 🇪🇸 Sobre el Proyecto

Este es un convertidor de monedas en **Java** con interfaz gráfica utilizando **Swing**, que obtiene tasas de cambio en tiempo real a través de la **ExchangeRate API**. Soporta tres idiomas y varias monedas sudamericanas.

---

## 🧰 Tecnologias | Technologies | Tecnologías

- Java 17+
- Swing (GUI)
- HttpClient (HTTP requests)
- Gson (JSON parsing)
- ResourceBundle (Multilingual support)

---

## 💬 Idiomas Suportados | Supported Languages | Idiomas Soportados

- 🇧🇷 Português  
- 🇺🇸 English  
- 🇪🇸 Español  

---

## 💸 Moedas Suportadas | Supported Currencies | Monedas Soportadas

- ARS - Peso Argentino / Argentinian Peso / Peso argentino 
- BOB - Boliviano / Bolivian / Boliviano  
- BRL - Real brasileiro / Brazilian Real / Real brasileño  
- CLP - Peso chileno / Chilean peso / Peso chileno 
- COP - Peso colombiano / Colombian Peso / Peso colombiano
- USD - Dólar americano / US Dollar / Dólar estadounidense
- PYG - Guarani paraguaio / Paraguayan Guarani / Guaraní paraguayo
- PEN - Sol peruano / Peruvian Sol / Sol peruana
- UYU - Peso uruguaio / Uruguayan peso / Peso uruguayo
- VES - Bolívar venezuelano / Venezuelan Bolivar / Bolívar venezolano
---

## 🔧 Configuração da API | API Setup | Configuración de la API

1. Cadastre-se em [ExchangeRate API](https://www.exchangerate-api.com/).
2. Copie sua chave de API gratuita.
3. No código, substitua:

```java
String url = API_URL.replace("SUA_API_KEY", "INSIRA_SUA_CHAVE_AQUI") + base;
```

por:

```java
String url = API_URL.replace("SUA_API_KEY", "SUA_CHAVE_REAL") + base;
```

---

## ▶️ Como Executar | How to Run | Cómo Ejecutar

1. Importe o projeto no IntelliJ IDEA ou outra IDE Java.
2. Adicione a biblioteca Gson (via Maven ou JAR).
3. Compile e execute `ConversorMoedasGUI.java`.

---

## 📸 Captura de Tela | Screenshot | Captura de Pantalla

![screenshot_conversor_moedas](https://github.com/user-attachments/assets/6403f7fb-5ad1-4d5d-bfd2-ad39321ecc9e)


## ✨ Funcionalidades | Features | Funcionalidades

- Interface amigável com Swing  
- Conversão em tempo real com dados atualizados  
- Suporte multilíngue  
- Validação de entrada  
- Layout simples e intuitivo  

---

## 👩‍💻 Autora | Author | Autora

**Karina Ivanova Varlamova**  

---

## 📝 Licença | License | Licencia

Este projeto é livre para uso educacional.  
This project is free for educational use.  
Este proyecto es libre para uso educativo.
