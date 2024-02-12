# Notas Compose prueba

## _Proyecto en desarrollo_

Una simple aplicación de notas, para cuardar notas y clasificarlos por etiquetas.

## ¿Que aplique en este proyecto?


- Arquitectura MVVM
- Navigarion
- 100% Kotlin
- Dagger hilt
- Base de datos local (ROOM)
- Coroutines
- Flow

## Contenido de tablas:

### NotasEntity
                    
Campo  | Tipo
------------- | -------------
id  | Int
titulo | String
mensaje | String
etiqueta | Int
create | Date
updated | Date

### EtiquetasEntity
                    
Campo  | Tipo
------------- | -------------
id  | Int
etiqueta | String
create | Date
