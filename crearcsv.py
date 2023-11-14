import csv

# Función para escribir un usuario no premium en el CSV
def escribir_usuario_no_premium(nombre, contrasena, plan, fecha_nacimiento):
    with open('usuarios.csv', mode='w', newline='') as file:
        fieldnames = ['Nombre', 'Contrasena', 'Plan', 'Fecha_Nacimiento']
        writer = csv.DictWriter(file, fieldnames=fieldnames)

        # Escribir encabezados
        writer.writeheader()

        # Escribir usuario no premium
        writer.writerow({'Nombre': nombre, 'Contrasena': contrasena, 'Plan': plan, 'Fecha_Nacimiento': fecha_nacimiento})

# Datos del usuario no premium
nombre_usuario = 'EjemploUsuario'
contrasena_usuario = 'Contrasena123'
plan_usuario = 'base'
fecha_nacimiento_usuario = '01/01/1990'

# Llamada a la función para escribir el usuario no premium en el CSV
escribir_usuario_no_premium(nombre_usuario, contrasena_usuario, plan_usuario, fecha_nacimiento_usuario)

print("CSV generado exitosamente.")
