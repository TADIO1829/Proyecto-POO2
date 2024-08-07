# "Instalacion"

Para el correcto uso del programa en un nuevo ordenador se debe cambiar algunas cosas en el mas especidicamente las rutas del algunos elementos

**MAIN:** en la main tocaria cambiar las ruta de las imagenes que estan en el comentado que hay desde la linea 85 hasta la 110 y ejectular la main, lo que haria que se suba las nuevas rutas de las imagenes a la base de datos

**CAJERO:** en la linea 76 se le cambia la ruta a la donde se encuentra el programa 

**CON ESO EL PROGRAMA DEBERIA FUNCIONAR CORRECTAMENTE**

# Explicacion del programa

**CLASES**

*Productos*

Representa al producto, cuenta con 3 atributos, 3 constructores(1 vacio, 1 semicompleto, 1 completo) y los getters de los atriutos
![image](https://github.com/user-attachments/assets/24ea1c31-b47f-4376-b05a-77470a924e58)
![image](https://github.com/user-attachments/assets/eeaedee4-f703-4edd-bea3-19b5c02e2b58)
![image](https://github.com/user-attachments/assets/beeb2063-83a8-497a-b7df-1b2e88efba37)

*Trabajadores*
Representa a los cajeros, con esta clase es con la que se ingresa nuevos cajeros a la base de datos (mas bien se usa los getters) y de una vez incripta la contraseña
![image](https://github.com/user-attachments/assets/67553a49-a5bb-4f47-b4a3-cf1cc6a31f84)
![image](https://github.com/user-attachments/assets/980bbc36-0015-43ac-912a-6c3b1fae99be)

*Usador*
Esta clase se creo con el unico objetivo de al iniciar sesion buscar el nombre del que inicio sesion asi si un cajero hace una factura se sabe quien fue
![image](https://github.com/user-attachments/assets/149c6277-909a-4a27-a497-8e433af29f02)
![image](https://github.com/user-attachments/assets/7bc94ab2-d9fd-43fa-8977-342d538c520b)

*PasswordUtils*
Se usa para encriptar y desencriptar las contraseñas , usa el algoritmo SHA-256 lo cual encripta rapido pero es menos seguro
![image](https://github.com/user-attachments/assets/1f1d81c6-0a9a-4dde-bad7-2d87b4fef5b0)

