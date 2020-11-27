# Evento-Madres
Taller Corte 3 - POO - Universidad Simon Bolivar
![alt text](https://res.cloudinary.com/dfmafb0cf/image/upload/v1606439187/Github/diagrama.jpg)

Se tienen las clases definidas en el diagrama. Corresponde a un proceso de inscripción de Madres e hijos
para un evento de festejo del Día de las Madres.

##### CLASE PERSONA
Es una clase abstracta que identifica al ente personas. Tiene los siguientes atributos:
a. identificacion: Cadena de caracteres que registra la identificación de la persona
b. nombre: Cadena de caracteres que guarda el nombre de la persona

##### CLASE MADRE
Es una clase que guarda a las madres que serán homenajeadas en el evento. Es una subclase de la clase
Persona y tiene los siguientes atributos propios:
a. profesion: Cadena de caracteres que guarda la profesión u oficio de la madre de familia
b. direccion: Cadena de caracteres que guarda la dirección de residencia de la madre. 

##### CLASE HIJO
Es una clase que guarda la información de los hijos que estarán en el homenaje a las madres,. Es una
subclase de Persona. Sus atributos propios son:
a) grado: Valor entero que identifica el grado en que se encuentra el estudiante. (De 1º a 11º.)
b) cedmad: Cadena de caracteres que guarda la identificación de la madre del joven.

##### ACTIVIDADES A DESARROLLAR
Se necesita la construcción de un programa de computador en Java que permita realizar las siguientes
acciones sobre las estructuras de datos de cada clase:

Clase Madre

- Registrar (crear) cada Madre que asistirá al evento. Se debe ingresar un objeto de esta clase en un
vector. La identificación de una madre es un atributo único por cada objeto.
- Listar Madres. Consiste en mostrar las madres que conforman el vector correspondiente a su clase.

Clase Hijo

- Registrar (crear) cada Hijo que asistirá al evento. Se debe ingresar un objeto de esta clase en un
vector. La identificación de un hijo es un atributo único por cada objeto.
- Listar Hijos. Consiste en mostrar las madres que conforman el vector correspondiente a su clase.

Consultas 

Se requieren las siguientes consultas:

- Hijos de una madre específica. El programa debe poder entregar el listado de los hijos que están
registrados bajo la identificación de una madre específica.
- Madre de un estudiante específico. El programa debe entregar el nombre de la madre de un
estudiante específico, para ello la entrada debe ser la identificación del estudiante. 

Diseñe y construya un programa en Java donde debe aplicar los conceptos de clases, encapsulamiento,
clases y métodos abstractos, interfaces, métodos constructores, getters y setters para implementar una
solución. En el programa se debe implementar un menú para el manejo de los requerimientos descritos. 
