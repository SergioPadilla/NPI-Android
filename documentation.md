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

## Aplicación 5
En esta aplicación hemos hecho uso de la modalidad de interacción **Realidad aumentada**.

Para realizarla, hemos hecho uso de la librería de realidad aumentada ***[wikitude](http://www.wikitude.com/)***. En esta aplicación haciendo uso de la cámara del móvil se muestran unas etiquetas que señalan ciertos puntos de interés de la provincia de Granada.