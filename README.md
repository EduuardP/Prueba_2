# Prueba_2

### Consumo de la Api Last.fm
Para el consumo de la api debido a la versión minima de Android 4 requerida, se consideró mejor usar la libreria OKHtpp a cambio de retrofit porque la versión más nueva no ofrecía soporte para Android 4.

Se implementó la libreria RxAndroid junto con su complemento RxJava, para manejar en otro hilo el proceso de descarga de los datos desde la API.

### Servicio de Firebase
Se realizó un sistema basico de Registro el cual utiliza el servicio de Autenticación de Firebase.
Se debe tener en cuenta que para compilar la app desde otro PC, es necesario agregar el SHA-1 a firebase.
Se iba a realizar la implementación de Analitica de Firebase pero la versión de la APi (14) para Android 4, no lo permitía.

