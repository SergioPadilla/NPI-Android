# José Pimentel Mesones y  Sergio Padilla López
#Descripción práctica 3
La práctica 3 se compone de  una aplicación principal en la que se muestran 5 botones en el que cada uno de ellos te lleva a una aplicación diferente, en ellas hemos ido incorporando diferentes sensores. Vamos a explicar una por una su funcionamiento y los sensores utilizados.

## Aplicación principal
Esta aplicación es un selector de actividades, está formado por 5 botones correspondientes a las 5 actividades que se pueden iniciar y un botón switch para manejar el audio entre actividades.

En esta activity, hemos utilizado la modalidad de interacción **Sonido**. Cuando la actividdad inicia, se reproduce un audio de fondo que siempre permanece activo en esta actividad. Con el botón switch, podemos controlar si queremos que la música siga sonando en el resto de actividades o solo en la inicial.

## Aplicación 1
En esta primera aplicación utilizamos la modalidad de interacción **Proactividad basada en localización** aplicando el **sensor de GPS**.

Para realizarla, hemos hecho uso del ***LocalizationManager*** que proporciona el SDK de android. Hemos creado una clase cuya funcionalidad es comprobar permisos y lo necesario para devolver una localización, así como devolverla. Además esta clase utiliza la modalidad de interacción **Visual en pantalla** para pedirle al usuario que active la localización del teléfono mediante un ***AlertDialog*** que corresponde con un actuador relacionado para esta modalidad de interacción en **Alertas y notificaciones**.

Haciendo uso de la clase anteriormente descrita, desde el activity se obtiene la localización y se encarga de mostrarlo en pantalla, aplicando la modalidad de interacción **Visual en pantalla**. El activity además hace uso de ***Geocoder*** nativo en android, que dada la localización obtenieda por el GPS (latitud y longitud) nos da la dirección completa del usuario (calle, codigo postal, ciudad y pais).

## Aplicación 2
Esta segunda aplicación es una variante de la primera, utilizamos la modalidad de interacción **Proactividad basada en localización** aplicando el sensor de **GPS** igual que antes, pero en este caso, lo hemos realizado a través de la API de google, ***Google Maps***, en la que google nos proporciona directamente la localización del usuario. Además aprovechando esta API, hemos mejorado la modalidad de interacción **Visual en pantalla** mostrando un mapa y colocando un marcador en la posición del usuario.

También cuando google nos devuelve la posición del usuario, además de marcarlo en el mapa mostramos un ***Toast*** con la localización a modo de **Alerta y notificación** mostrando al usuario sus coordenadas durante un breve periodo de tiempo.

En esta aplicación hemos insertado una barra encima del mapa, que nos permite introducir manualmente unas coordenadas (latitud y longitud) y un botón, al clickar sobre este botón se dibuja en el mapa una línea que une la posición actual con la posición introducida.

##Aplicación 3
En esta aplicación hacemos uso de las modalidades de interacción **Moviemiento del telefono** mediante el uso del sensor ***Acelerómetro*** y **Proactividad basada en localización** con el sensor ***Brújula (Magnético).***

Dicha información se traduce en un giro adecuado de una imagen de una aguja superpuesta sobre una imagen fija de una brújula, con el fin de simular una brújula, haciendo asi uso de la modalidad de interacción **Visual en pantalla** mediante el actuador ***Mostrar información en pantalla*** que nos muestra ademas los grados que tiene la orientacion de nuestro movil respecto al norte.

Usamos  el acelerómetro y el sensor magnético, mediante las librerias de Hardware que nos proporciona el SDK de Android como *SensorManager*, para conocer la posición en la que se encuentra el dispositivo respecto al norte magnético.

Ambos sensores nos devuelven vectores tridimensionales, con los valores captados por el sensor, en el caso del sensor de orientacion nos devuelve los angulos de navegacion "Azimuth" , "pitch" y "roll" que respectivamente giran sobre el eje Z, eje X y eje Y	.
 
 En el caso del sensor magnético nos devuelve la fuerza del campo electromacnético sobre los ejes X, Y y Z en las posiciones 0,1 y 2 respectivamente. 
A continuacion las componemos y nos quedamos solamente con la primera componente para girar convenientemente la flecha de la brújula .

##Aplicación 4
En esta aplicación hacemos uso de las modalidades de interacción **Interacción multitáctil** mediante el uso de ***Patrones sobre la pantalla*** y ***Pulsaciones sobre la pantalla de más de un dedo***

Dicha información se refleja en una imagen de una pizarra, en la que realizaremos diferentes gestos y se dibujará dicho gesto en ella, acompañado de diferentes vibraciones acordes a los gestos haciendo así uso de la modalidad de interacción **Visual en pantalla** mediante el actuador ***Mostrar información en pantalla*** y la modalidad de interacción **Vibración**

Para reconocer los diferentes gestos multitactiles hemos usado la librería [SimpleFingerGestures](https://github.com/championswimmer/SimpleFingerGestures_Android_Library)

## Aplicación 5
En esta aplicación hemos hecho uso de la modalidad de interacción **Realidad aumentada**.

Para realizarla, hemos hecho uso de la librería de realidad aumentada ***[wikitude](http://www.wikitude.com/)***. En esta aplicación haciendo uso de la cámara del móvil se muestran unas etiquetas que señalan ciertos puntos de interés de la provincia de Granada.