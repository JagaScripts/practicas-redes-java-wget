# practicas-redes-java-wget
Prácticas realizadas en equipo en la Universitat Autònoma de Barcelona Programación Orientada a Objetos Java de la asignatura de Redes, donde realizamos una aplicación cliente tipo wget.

## Uso
### Sin Docker

Necesitas tener insaldo y configurado un JDK en tu máquina. 

El código de esta práctica esta pensado para ejcutarlo en linea de comandos necesita de un archivo donde **cada línea es una url completa Ejemplo: http://www.jagascripts.com** y descargara el recurso especificado después del argumento -c en la carpeta downloads, si no existiera la url por defecto es "http://www.google.com" que se agregaría al fichero especificado o a uno creado por defecto "fitxerURLs.txt". Se van graegando todas la URL que vas especificadas o no y las descarga todas según se especifique compresión o filtrado mediante hilos. 

El comando básico posicionado en la carpeta de las clases para que funcione es el siguiente:

`$ java wget`

Si además queremos aplicar un filtro donde el archivo descargado html queda en ASCII le pasaremos el argumento -a, de la siguiente forma.

`$ java wget -a`

Si además queremos aplicar una compresión existen los argumentos -z y -gz para zip y gzip respectivamente.

`$ java wget -z -gzip`

Para especificar el archivo.

`$ java wget -f nombredelarchivo.txt`

Para especificar una url.

`$ java wget -c http://www.laurldeseada.com`

### Con Docker

Necesitas tener Docker en tu máquina instalado.

El funcionamiento es el mismo especificado en el apartado anterior, a diferencia que el Dockerfile y el docker-compose.yml estan preparados para que solo modifiques los argumentos de lo que quieres hacer es decir:

#### Con docker consturyendo la imagen y ejecutando el contenedor

Primero construimos la imagen mediante el comando `docker build -t nombreImagenquetuquieras`y despúes ejecutamos el contenedor con el comando `docker run --name nombreAppquetuquieras nombreImagenquetuquieras argumentos` en la ruta de la carpeta y el resultado aparecera en la carpeta downloads

#### Con docker-compose autogenerado de imagen y auto ejecutado

En el documento docker-compose.yml en el apartado "command:" especificaremos los argumentos sin el `java wget` y ejecutaramos `$ docker-compose up -d` en la ruta de la carpeta y el resultado aparecera en la carpeta downloads.






