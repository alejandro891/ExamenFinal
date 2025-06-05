#  Proyecto Final – *Juego del Ahorcado (Multicapa en Java)*

##  Nombre del Proyecto
**" Juego del Ahorcado "** – Juego clásico del ahorcado desarrollado con estructura multicapa orientada a objetos en Java.

##  Integrantes del Grupo y Roles

| Nombre                | Rol                             |
|------------------------|----------------------------------|
| Persona 1             | Modelo de datos (`PalabraSecreta`, `Jugador`) |
| Persona 2             | Lógica de negocio (`JuegoServicio`) |
| Persona 3             | Interfaz visual de consola (`ConsolaVista`) |
| Persona 4             | Utilidades y validación (`Dibujador`) |

##  Descripción del problema y solución propuesta

**Problema:**  
Desarrollar un programa interactivo que permita jugar al clásico juego del *Ahorcado*, con seguimiento de partidas ganadas y perdidas, selección aleatoria de palabras y validación de entradas del usuario.

**Solución:**  
Se propuso un programa en **Java orientada a objetos**, que separa responsabilidades en distintas clases distribuidas en capas: modelo, servicio, vista y utilidades. Cada clase cumple una función específica y reutilizable, facilitando el mantenimiento y escalabilidad del sistema.

##  Estructura del Proyecto y Explicación de Clases

\`\`\`
src/
├── modelo/
│   ├── PalabraSecreta.java      # Clase que almacena palabra y pista
│   ├── Persona.java             # Clase base con estadísticas
│   └── Jugador.java             # Hereda de Persona
│
├── servicio/
│   └── JuegoServicio.java       # Lógica del juego (flujo principal)
│
├── util/
│   └── Dibujador.java           # Dibuja el ahorcado y muestra estado
│
└── vista/
    └── ConsolaVista.java        # Main que lanza la app
\`\`\`

###  Clases Principales

- **`PalabraSecreta`**  
  Representa la palabra a adivinar y su pista. Usa encapsulamiento.

- **`Jugador`** *(hereda de Persona)*  
  Guarda estadísticas de partidas ganadas y perdidas.

- **`JuegoServicio`**  
  Contiene toda la lógica: seleccionar palabra, recibir letras, verificar aciertos y mostrar resultados.

- **`Dibujador`**  
  Encargado de mostrar el dibujo del ahorcado y el progreso del jugador.

- **`ConsolaVista`**  
  Clase principal que crea el jugador y ejecuta el flujo del juego.

##  Instrucciones para Ejecutar el Programa

1. **Clona o descarga** el repositorio:
   \`\`\`bash
   git clone https://github.com/alejandro891/ExamenFinal.git
   \`\`\`

2. **Abre la carpeta en VSCode** 

3. **Estructura de carpetas esperada:**

   \`\`\`
   src/
     modelo/
     servicio/
     util/
     vista/
     main.java
   \`\`\`

5. **Compila los archivos:**

   Si estás usando terminal, desde la carpeta `src`:
   \`\`\`bash
   javac modelo/*.java servicio/*.java util/*.java vista/*.java
   \`\`\`

6. **Ejecuta el programa:**

   \`\`\`
   ejecuta el programa oprimiendo AltGr + f5
   \`\`\`

##  Ejemplos de uso

\`\`\`
=== NUEVA PARTIDA DEL AHORCADO ===
 Escribes código para resolver problemas.

 +---+
 |   |
     |
     |
     |
     |
=========

Palabra: _ _ _ _ _ _ _ _ _ _ _ _
Letras usadas: []

Ingresa una letra: A
¡Letra correcta!

...

¿Quieres jugar otra vez? (s/n): n

Resumen de partidas:
Ganadas: 2
Perdidas: 1
Gracias por jugar.
\`\`\`

##  Características implementadas

- [x] Herencia (`Jugador` extiende `Persona`)
- [x] Encapsulamiento (atributos privados, getters/setters)
- [x] Validación de entrada con `try/catch`
- [x] Uso de `Set`, `Array`, `Random`, `Scanner`
- [x] Reutilización de métodos (`actualizarProgreso`, `leerLetra`)
- [x] Dibujo visual dinámico del ahorcado
- [x] Resumen de estadísticas al finalizar

## Capturas de pantalla 
- ejecutamos: y nos dice que ingresemos una letra y nos da una pista para adivinar la palabra.
  
![image](https://github.com/user-attachments/assets/b97ec950-a9bd-441a-ad38-4a2f30e77f78)

- Ingresamos por teclado una letra y cada letra ingresada la va mostrando
  
![image](https://github.com/user-attachments/assets/143a9a71-47cd-4c4e-af79-e7a0e4f1f093)

- Si la letra esta en la palabra marca como correcta :)
  
![image](https://github.com/user-attachments/assets/681062f9-8119-4c47-a7d8-5f3c7aa41312)

- Si ingresa una letra y no esta la palabra marca como incorrecta :(
 
![image](https://github.com/user-attachments/assets/70b57d23-04b5-420a-bd4d-22594548f878)

- Y si ingresa mas de una letra o un numero, le dice al usuario que ingrese un letra
 
![image](https://github.com/user-attachments/assets/1eadfdb4-16de-4268-826a-a008aab3854d)

- El programa sigue con el mismo orden hasta que adivine la palabra o se complete el ahorcado y le pregunta al usuario si desea jugar otra vez con (s/n)
 
![image](https://github.com/user-attachments/assets/7f760a2f-40a3-47de-acfc-42c6e7d3efda)
![image](https://github.com/user-attachments/assets/c17f2fcc-c7fd-4d1c-acbf-3785f93c9fc0)

- Si el usuario ingresa n, le va a mostrar cuantas partidas gano y perdio.

![image](https://github.com/user-attachments/assets/ce4b6dc9-5d82-47cc-9630-cb6fd89dac24)








