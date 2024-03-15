
Actividad: Desarrollo de Proyecto Software en Kotlin
ID actividad: 2324_PRO_u4u5u6_libre
Agrupamiento de la actividad: Individual

Descripción:
La actividad consiste en el desarrollo de un proyecto software en Kotlin, permitiendo al estudiante elegir la temática. Este proyecto debe demostrar la comprensión y aplicación de los conceptos de programación orientada a objetos (POO), incluyendo la definición y uso de clases, herencia, interfaces, genericos, principios SOLID y el uso de librerías externas.
Objetivo:
    • Demostrar comprensión de los fundamentos de POO mediante la instanciación y uso de objetos. 
    • Aplicar conceptos avanzados de POO como herencia, clases abstractas, e interfaces. 
    • Crear y usar clases que hagan uso de genéricos. 
    • Aplicar principios SOLID. 
    • Integrar y utilizar librerías de clases externas para extender la funcionalidad del proyecto. 
    • Documentar y presentar el código de manera clara y comprensible. 
Trabajo a realizar:
    1. Selección de la Temática: Elige un tema de tu interés que pueda ser abordado mediante una aplicación software. Esto podría ser desde una aplicación de gestión para una pequeña empresa, una herramienta para ayudar en la educación, hasta un juego simple. Define claramente el problema que tu aplicación pretende resolver.
    2. Planificación: Documenta brevemente cómo tu aplicación solucionará el problema seleccionado, incluyendo las funcionalidades principales que desarrollarás.
    3. Desarrollo:
        ◦ Instancia de Objetos: Tu aplicación debe crear y utilizar objetos, demostrando tu comprensión de la instanciación y el uso de constructores, métodos, y propiedades. 
        ◦ Métodos Estáticos: Define y utiliza al menos un método estático, explicando por qué es necesario en tu aplicación. 
        ◦ Uso de IDE: Desarrolla tu proyecto utilizando un IDE, aprovechando sus herramientas para escribir, compilar, y probar tu código. 
        ◦ Definición de Clases: Crea clases personalizadas con sus respectivas propiedades, métodos, y constructores. 
        ◦ Clases con genéricos: Define y utiliza al menos una clase que haga uso de genéricos en tu aplicación. 
        ◦ Herencia y Polimorfismo: Implementa herencia y/o interfaces en tu proyecto para demostrar la reutilización de código y la flexibilidad de tu diseño. Usa los principios SOLID: Ten presente durante el desarrollo los principios SOLID y úsalos durante el diseño para mejorar tu aplicación. 
        ◦ Librerías de Clases: Integra y utiliza una o más librerías externas que enriquezcan la funcionalidad de tu aplicación. 
        ◦ Documentación: Comenta tu código de manera efectiva, facilitando su comprensión y mantenimiento. 
    4. Prueba y Depuración: Realiza pruebas para asegurarte de que tu aplicación funciona como se espera y depura cualquier error encontrado.
    5. Contesta a las preguntas ver el punto Preguntas para la Evaluación
Recursos
    • Apuntes dados en clase sobre programación orientada a objetos, Kotlin, uso de IDEs, y manejo de librerías. 
    • Recursos vistos en clase, incluyendo ejemplos de código, documentación de Kotlin, y guías de uso de librerías. 
Evaluación y calificación
RA y CE evaluados: Resultados de Aprendizaje 2, 4, 6, 7 y Criterios de Evaluación asociados.
Conlleva presentación: SI
Rubrica: Mas adelante se mostrará la rubrica.
Entrega
La entrega tiene que cumplir las condiciones de entrega para poder ser calificada. En caso de no cumplirlas podría calificarse como no entregada.
    • Conlleva la entrega de URL a repositorio: El contenido se entregará en un repositorio GitHub. 
    • Respuestas a las preguntas: Deben contestarse en este fichero, README.md 
Preguntas para la Evaluación
Este conjunto de preguntas está diseñado para ayudarte a reflexionar sobre cómo has aplicado los criterios de evaluación en tu proyecto. Al responderlas, asegúrate de hacer referencia y enlazar al código relevante en tu README.md, facilitando así la evaluación de tu trabajo.
Criterio global 1: Instancia objetos y hacer uso de ellos
    • (2.a, 2.b, 2.c, 2.d, 2.f, 2.h, 4.f, 4.a): Describe cómo has instanciado y utilizado objetos en tu proyecto. ¿Cómo has aplicado los constructores y pasado parámetros a los métodos? Proporciona ejemplos específicos de tu código.
      [EJEMPLO CODIGO 1](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/MainMenu.kt) Como se puede ver, he instanciado la clase SecondaryMenus, la cual contiene todos los submenus del programa. 
      [EJEMPLO CODIGO 2](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/SecondaryMenus.kt) Como se ve en el ejemplo 2, he pasado los parametros a los constructores, utilizado clases externas de input y output para obtener los datos necesarios. (Cumpliendo asi con el modelo vista controlador)
Criterio global 2: Crear y llamar métodos estáticos
    • (4.i): ¿Has definido algún método/propiedad estático en tu proyecto? ¿Cuál era el objetivo y por qué consideraste que debía ser estático en lugar de un método/propiedad de instancia?
    • (2.e): ¿En qué parte del código se llama a un método estático o se utiliza la propiedad estática?
      [EJEMPLO CODIGO 3](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/Team.kt) En este caso cree un metodo estático y una propiedad estatica. El metodo es para crear nuevos equipos y la propiedad es para tener un registro de los equipos que existen. Ejemplo Codigo 4 En la linea 35 se utiliza el metodo estatico para crear equipos y en la linea 99 la propiedad de los equipos existentes para comprobar si el nombre del equipo que se busca existe en el sistema.
Criterio global 3: Uso de entornos
    • (2.i): ¿Cómo utilizaste el IDE para el desarrollo de tu proyecto? Describe el proceso de creación, compilación, y prueba de tu programa. El IDE lo he utilizado para crear el conjunto del programa, todas las clases y elementos del mismo han sido usando el mismo IDE IntelliJ IDEA. He compilado el programa, utilizado el debugger para encontrar ciertos errores en los metodos y probado con tests. 
    [EJEMPLO CODIGO 4](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/test/kotlin/ProjectManagementTest.kt) He hecho un test a una función de la clase ProjectManagement
Criterio global 4: Definir clases y su contenido
    • (4.b, 4.c, 4.d, 4.g): Explica sobre un ejemplo de tu código, cómo definiste las clases en tu proyecto, es decir como identificaste las de propiedades, métodos y constructores y modificadores del control de acceso a métodos y propiedades, para representar al objeto del mundo real. ¿Cómo contribuyen estas clases a la solución del problema que tu aplicación aborda? 
    • [EJEMPLO CODIGO 5](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/Employee.kt) En este ejemplo se puede ver la clase abstracta Employee. Primero sabía que debía ser una clase abstracta porque quería crear distintos tipos de trabajadores en el progama y muchos de sus metodos serian compartidos. Lo básico de la clase Employee son, su nombre, su puesto y sus habilidades que por defecto viene sin pero pueden ser añadidas desde fuera. Para cumplir con la encasulapcion de la programación orientada a objetos, puse todas sus propiedades en privado e iba creando métodos para acceder a ellos segun me hicieran falta. Estas clases permiten una mayor flexibilidad al código ya que para crear un nuevo empleado solo debería heredar de la clase abstracta Employee y salvaría mucho código y tiempo. 
Criterio global 5: Herencia y uso de clases abstractas e interfaces
    • (4.h, 4.j, 7.a, 7.b, 7.c): Describe sobre tu código cómo has implementado la herencia o utilizado interfaces en tu proyecto. ¿Por qué elegiste este enfoque y cómo beneficia a la estructura de tu aplicación? ¿De qué manera has utilizado los principios SOLID para mejorar el diseño de tu proyecto? ¿Mostrando tu código, contesta a qué principios has utilizado y qué beneficio has obtenido? 
    • [EJEMPLO CODIGO 7](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/Project.kt) La herencia me sirve para cumplir los principios SOLID y con ello obtener una flexibilidad en el código y no estar atado a detalles sino a abstracciones lo cual hace más fácil la mantenibilidad del proyecto. En este ejemplo he cumplido con el principio de Responsabilidad Mínima y el principio de Inversión de dependencias para así tener una mayor legibilidad con el SRP y una mayor mantenibilidad a futuro con el principio DIP 
    
Criterio global 6: Diseño de jerarquía de clases
    • (7.d, 7.e, 7.f, 7.g): Presenta la jerarquía de clases que diseñaste. ¿Cómo probaste y depuraste esta jerarquía para asegurar su correcto funcionamiento? ¿Qué tipo de herencia has utilizado: Especificación, Especialización, Extensión, Construcción? 
    • He utilizado especialización, la cual probe a través de la herencia de las clases. Creando clases más específicas heredando de otras más generales. 
    
Criterio global 7: Librerías de clases
    • (2.g, 4.k): Describe cualquier librería externa que hayas incorporado en tu proyecto. Explica cómo y por qué las elegiste, y cómo las incorporaste en tu proyecto. ¿Cómo extendió la funcionalidad de tu aplicación? Proporciona ejemplos específicos de su uso en tu proyecto. 
    • [EJEMPLO CODIGO 8](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/MainMenu.kt) He utilizado la librería Mordant, el cual mejora el aspecto visual de la terminal. 
Criterio global 8: Documentado
    • (7.h): Muestra ejemplos de cómo has documentado y comentado tu código. ¿Que herramientas has utilizado? ¿Cómo aseguras que tu documentación aporte valor para la comprensión, mantenimiento y depuración del código? 
    • [EJEMPLO CODIGO 9](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/Project.kt) He utilizado el lenguaje KDoc para documentarlo, el cual explica mejor el funcionamiento de las clases, propiedades y métodos para que sea más fácil y rápido la comprensión de los diferentes elementos del programa. 
Criterio global 9: Genéricos
    • (6.f): Muestra ejemplos de tu código sobre cómo has implementado una clase con genéricos. ¿Qué beneficio has obtenido? 
    • [EJEMPLO CODIGO 10](https://github.com/IES-Rafael-Alberti/prog-practica-libre-trimestre-2-Llavesuke/blob/mainFinal/src/main/kotlin/Team.kt) He implementado una clase con genericos, en este caso Team, he obtenido un beneficio al poder tratar cualquier tipo de empleado que introduzca en la clase de la misma manera 
