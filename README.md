#  Proyecto Final – *Juego del Ahorcado (Multicapa en Java)*

##  Nombre del Proyecto
**"Ahorcado Plus"** – Juego clásico del ahorcado desarrollado con estructura multicapa orientada a objetos en Java.

##  Integrantes del Grupo y Roles

| Nombre                | Rol                             |
|------------------------|----------------------------------|
| Persona 1             | Modelo de datos (`PalabraSecreta`, `Jugador`) |
| Persona 2             | Lógica de negocio (`JuegoServicio`) |
| Persona 3             | Interfaz visual de consola (`ConsolaVista`) |
| Persona 4             | Utilidades y validación (`Dibujador`) |

##  Descripción del problema y solución propuesta

**Problema:**  
Desarrollar una aplicación interactiva que permita jugar al clásico juego del *Ahorcado*, con seguimiento de partidas ganadas y perdidas, selección aleatoria de palabras y validación de entradas del usuario.

**Solución:**  
Se propuso una aplicación en **Java orientada a objetos**, que separa responsabilidades en distintas clases distribuidas en capas: modelo, servicio, vista y utilidades. Cada clase cumple una función específica y reutilizable, facilitando el mantenimiento y escalabilidad del sistema.

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
   git clone https://github.com/tuusuario/ahorcado-plus.git
   \`\`\`

2. **Abre la carpeta en VSCode** o cualquier IDE de Java (Eclipse, IntelliJ, etc.)

3. **Estructura de carpetas esperada:**

   \`\`\`
   src/
     modelo/
     servicio/
     util/
     vista/
   \`\`\`

4. **Compila los archivos:**

   Si estás usando terminal, desde la carpeta `src`:
   \`\`\`bash
   javac modelo/*.java servicio/*.java util/*.java vista/*.java
   \`\`\`

5. **Ejecuta el programa:**

   \`\`\`bash
   java vista.ConsolaVista
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
