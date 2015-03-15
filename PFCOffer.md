# PACA #

A continuación se muestran una serie de proyectos fin de carrera relacionados
el si sistema de corrección automática ''PACA'' utilizado actualmente en la
asignatura de Estructura de Datos en las carreras de Ingeniería en Informática
de Gestión en la Universidad Rey Juan Carlos.

Este sistema de corrección automática está basado en la tecnología de sistemas
multi-agente sobre la plataforma JADE, con una interfaz web para el usuario.
Básicamente el sistema funciona así:

  * Autoriza al usuario mediante su nombre y contraseña
  * PACA le muestra la prácticas disponibles en ese momento
  * El alumno selecciona la práctica y puede decidir entre realizar una entrega o hacer una evaluación preliminar
  * En la evaluación preliminar selecciona los casos de prueba a evaluar y proporciona al sistema los ficheros que requiere para poder ejecutar los casos de prueba
  * PACA ofrece un informe sobre la corrección de la práctica, indicando desde errores de compilación o ejecución a errores en los resultados generados por los ficheros proporcionados por el usuario

El sistema detallado, actualmente en producción, tiene infinidad de posibilidades de mejora. Se ofertan a continuación una serie de proyectos fin de carrera relacionados con distintos posibles aspectos de mejora de ''PACA''. Un aliciente particular de estos proyectos es que no únicamente servirán para aprobar una asignatura de la carrera, sino que además todo ese trabajo será utilizado de forma intensiva por las siguientes promociones de alumnos.

## PACA: Paralelización del sistema de corrección ##

**Asignado: Carlos Simón**

### Tutores ###
Sergio Saugar y Rubén Ortiz

### Descripción ###

Actualmente el sistema PACA tiene un único agente encargado de hacer una evaluación
secuencial de las prácticas de los alumnos. En ciertos momentos existe una gran demanda
de evaluaciones (proximidad a la entrega de prácticas), con gran cantidad de alumnos
interactuando de forma simultánea, que deben esperar a que el corrector quede libre
para que corrija sus prácticas. Además la corrección (supone compilar y ejecutar un programa
múltiples veces) supone una intensa carga para el ordenador que realiza esa tarea, por lo que
también sería deseable que pudiese ser repartida.

El proyecto abordaría el problema de paralelización y reparto de carga en un entorno
de sistemas multi-agente.

### Tecnología ###

Para desarrollar este proyecto es necesario programar en Java y estar dispuesto a
abordar el aprendizaje del paradigma de sistemas multi-agente (MAS) Se utilizará una
plataforma de agentes consolidada (JADE). Habilidad con los sistemas distribuidos.

## PACA: Gestión avanzada de usuarios ##

**Asignado: Carlos Beriso**

### Tutores ###
Sergio Saugar y Rubén Ortiz

### Descripción ###
En PACA la gestión de usuarios es básica, únicamente basada en los datos referentes
a los nombres de usuario y contraseña. Con este proyecto se pretende abordad una
gestión más completa de los usuarios. De esta manera se ofrecerá, además de las opciones
de evaluación de prácticas, opciones para los usuarios para personalizar el uso del sistema,
ya sea con perfiles de usuario, estadísticas sobre uso del sistema, cambios de los datos
personales, preferencias de uso (prácticas y casos por defecto), informes de progresos, etc.

También se abordarán los distintos roles disponibles en el sistema: véase alumnos y profesores,
ofreciendo interfaces diferenciadas y opciones de configuración distintas. Por ejemplo, para los
usuarios que desempeñen el role de profesor se les ofrecerá la administración de sus alumnos,
pudiendo dar altas o bajas.

Supone un estudio sobre la información necesaria a manejar, los datos a almacenar en el sistema,
la identificación de los roles que participan y distintas interfaces web para cada uno de ellos.

### Tecnología ###

Para desarrollar este proyecto es necesario programar en Java y estar dispuesto a
abordar el aprendizaje del paradigma de sistemas multi-agente (MAS) Se utilizará una
plataforma de agentes consolidada (JADE). Programación de aplicaciones web sobre
servidores de aplicaciones java.

## PACA: Gestión de prácticas, interfaz web para prácticas de caja negra ##

**Asignado: Raquel Blasco**

### Tutores ###
Sergio Saugar y Rubén Ortiz

### Descripción ###

Un aspecto importante en PACA y que requiere de un esfuerzo por parte de los profesores
es la confección de las prácticas, todos los ficheros necesarios, así como el diseño
de todos los casos de prueba.

PACA posee un sistema de configuración externo a su interfaz web, con un esquema de
diseño de prácticas muy simple. El proyecto abordaría la creación de prácticas, junto
al diseño de casos de prueba únicamente basado en método de caja negra (método ya utilizado).
Este nuevo sistema de gestión de prácticas se integraría en la interfaz web de PACA
y sería el encargado de proporcionar todos los datos referentes a las prácticas
tanto a las interfaces web como a los agentes correctores.

### Tecnología ###

Para desarrollar este proyecto es necesario programar en Java y estar dispuesto a
abordar el aprendizaje del paradigma de sistemas multi-agente (MAS) Se utilizará una
plataforma de agentes consolidada (JADE). Programación de aplicaciones web sobre
servidores de aplicaciones java.

## PACA: Gestión de prácticas: diseño de prácticas ##

### Tutores ###
Sergio Saugar y Rubén Ortiz

### Descripción ###

Un aspecto importante en PACA y que requiere de un esfuerzo por parte de los profesores
es la confección de las prácticas, todos los ficheros necesarios, así como el diseño
de todos los casos de prueba.

PACA posee un sistema de configuración externo a su interfaz web, con un esquema de
diseño de prácticas muy simple. El proyecto abordaría el estudio y la creación de distintos
tipos de prácticas, no únicamente basado en método de caja negra. Este nuevo sistema
se integraría con la interfaz web de PACA y sería el encargado de proporcionar todos
los datos referentes a las prácticas tanto a las interfaces web como a los agentes
correctores para que apliquen las pruebas y criterios especificados. Además de ofrecer
en la configuración los distintos tipos de práctica analizados y estimados propicios para
el sistema, debe proveer de una interfaz abierta para completa definición de nuevos tipos
de prácticas y test.

El proyecto reutilizará gran parte de la interfaz creada en el proyecto para la creación
de la interfaz web para la configuración de prácticas de caja negra.

### Tecnología ###

Para desarrollar este proyecto es necesario programar en Java y estar dispuesto a
abordar el aprendizaje del paradigma de sistemas multi-agente (MAS) Se utilizará una
plataforma de agentes consolidada (JADE). Programación de aplicaciones web sobre
servidores de aplicaciones java.

## PACA: Estadísticas de correcciones y uso web ##

### Tutores ###
Sergio Saugar y Rubén Ortiz

### Descripción ###

Todas las correcciones realizadas por los alumnos, las prácticas que suponen una mayor dificultad
(mayor número de pruebas, mayor cantidad de errores ...), las más sencillas, los alumnos
más participativos. Todos estos indicadores y más ofrecen al profesor información adicional
a la hora de evaluar las prácticas y el trabajo de los alumnos. Además para los alumnos también
puede ser un indicativo de su actividad en el sistema y para identificar en qué aspectos tienen
una mayor dificultad.

El proyecto aborda la recolección de toda la información generada por PACA y su presentación
mediante interfaz web, integrada en el sistema, de estadísticas con distintos niveles de
agregación (por alumnos, grupos, prácticas, etc. )

### Tecnología ###

Para desarrollar este proyecto es necesario programar en Java y estar dispuesto a
abordar el aprendizaje del paradigma de sistemas multi-agente (MAS) Se utilizará una
plataforma de agentes consolidada (JADE). Programación de aplicaciones web sobre
servidores de aplicaciones java.


## Bibliografía ##

  * Agentes software y sistemas multiagente conceptos, arquitecturas y aplicaciones \\ Mas, Ana \\ Editor: Pearson Prentice  Hall \\ Fecha de pub: D.L. 2004 \\ Páginas: XIV, 286 p. \\ ISBN: 8420543675
  * http://jade.tilab.com/