# practicas-redes-java-wget
Prácticas realizadas en equipo en la Universitat Autònoma de Barcelona Programación Orientada a Objetos Java de la asignatura de Redes, donde realizamos una aplicación cliente tipo wget.

## Uso
### Sin Docker

Necesitas tener insaldo y configurado un JDK en tu máquina. 

El código de esta práctica esta pensado para ejcutarlo en linea de comandos necesita de un archivo donde **cada línea es una url completa Ejemplo: http://www.jagascripts.com/** y descargara el recurso especificado, si no existiera el archivo crea uno por defecto llamado fitxerURLs.txt. 

El comando básico posicionado en la carpeta de las clases para que funcione es el siguiente:

`$ java wget`

Si además queremos aplicar un filtro donde el archivo descargado html queda en ASCII le pasaremos el argumento -a, de la siguiente forma.

`$ java wget -a`

Si además queremos aplicar una compresión existen los argumentos -z y -gz para zip y gzip respectivamente.

`$ java wget -z -gzip`

Para especificar el archivo.

`$ java wget -f nombredelarchivo.txt`

### Con Docker

Necesitas tener Docker en tu máquina instalado.

El código de esta práctica esta pensado para ejcutarlo en linea de comandos necesita de un archivo donde **cada línea es una url completa Ejemplo: http://www.jagascripts.com/** y descargara el recurso especificado, si no existiera el archivo crea uno por defecto llamado fitxerURLs.txt. 

El comando básico posicionado en la carpeta de las clases para que funcione es el siguiente:

`$ java wget`

Si además queremos aplicar un filtro donde el archivo descargado html queda en ASCII le pasaremos el argumento -a, de la siguiente forma.

`$ java wget -a`

Si además queremos aplicar una compresión existen los argumentos -z y -gz para zip y gzip respectivamente.

`$ java wget -z -gzip`

Para especificar el archivo.

`$ java wget -f nombredelarchivo.txt`



