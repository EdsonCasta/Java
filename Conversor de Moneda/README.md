💱 Conversor de Monedas en Java
-
Este proyecto es una aplicación de consola en Java que permite realizar conversiones entre distintas monedas utilizando la API de ExchangeRate-API. Está diseñado como parte de un desafío educativo, con enfoque en el aprendizaje del uso de HttpClient, manejo de JSON con Gson y lógica de programación modular.

🚀 Funcionalidades
-
- Conversión en tiempo real entre:

  - Peso colombiano (COP) y Dólar (USD)

  - COP y Peso mexicano (MXN)

  - COP y Peso argentino (ARS)

  - En ambos sentidos

- Lógica modular y orientada a objetos

- Uso de la API pública de ExchangeRate

- Interfaz en consola amigable con menú interactivo


🛠️ Tecnologías utilizadas
-
- Java 17+

- Gson (para parsear JSON)

- HttpClient (para hacer solicitudes HTTP)

- Scanner (para interacción por consola)


📋 Requisitos
-
- JDK 17 o superior

- Conexión a internet (para consumir la API)

- Gson (debe estar en el classpath)


🔧 Instrucciones para ejecutar
-
1. Clona el repositorio o descarga los archivos fuente.

2. Asegúrate de tener Gson agregado al proyecto.

3. Compila y ejecuta desde la terminal:

🖥️ Linux / macOS:

javac -cp gson-2.10.1.jar *.java

java -cp .:gson-2.10.1.jar Principal

🪟 Windows:

javac -cp gson-2.10.1.jar *.java

java -cp .;gson-2.10.1.jar Principal


📌 API utilizada
-
- ExchangeRate-API 
  - Endpoint usado: https://v6.exchangerate-api.com/v6/YOUR_API_KEY/pair/{FROM}/{TO}

⚠️ Asegúrate de reemplazar YOUR_API_KEY por tu propia clave de API gratuita desde su sitio oficial.


📚 Aprendizajes clave
-
- Uso de HttpClient, HttpRequest, HttpResponse

- Lectura de JSON con Gson

- Interacción por consola

- Programación modular en Java

- Bucles y control de flujo con switch, while, if


📌 Ejemplo de uso
-
***********************************************************

¡BIENVENIDOS A SU APLICACIÓN DE CONVERSOR DE MONEDA!

1) Peso colombiano => Dólar (COP => USD)
2) Dólar => Peso colombiano (USD => COP)
3) Peso colombiano => Peso mexicano (COP => MXN)
4) Peso mexicano => Peso colombiano (MXN => COP)
5) Peso colombiano => Peso argentino (COP => ARS)
6) Peso argentino => Peso colombiano (ARS => COP)
7) Salir

Elija una opción válida:

***********************************************************

2

Ingresa el valor a convertir:
100

El valor de: 100.0

Equivale a: 421893.93

📃 Licencia
-
Este proyecto se desarrolló con fines educativos. Puedes modificarlo y adaptarlo libremente para tus propios fines.