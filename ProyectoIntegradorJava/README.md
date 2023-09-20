# Integrador_java
Program that simulates the use of an Iron Man armor
## Task
- [x] Add new Radar
- [x] Improve decisions
- [x] Improve enemies
- [ ] Order code
- [ ] Add Testing
- [ ] Imporve Interface
## Observations
Works well for now...
## Updates
- [X] Method "consultarDistancia" -> consumes energy from the helmet
- [x] Method "comprobarDisparo" ->  consumes energy from the gloves
- [x] Class "AccionesImplementService" -> limited the use of energy in all methods of the class
- [x] Package "constants" Class "Constant" -> added 
- [x] Class "Objetos" -> attribute "nvlResis" added
- [x] Class "Objetos -> attribute "salud" added
- [x] Class "AccionesImplementService" -> enemies resist shots according to their hardness
- [x] Class "Armadura" -> atrributes "distanciaRecorrida, posicX, posicY, posicZ" added
- [x] Class "Objetos" -> attibute "distancia" replaced by "posicX, posicY, posicZ"
- [x] Class "RadioImplementService" -> method: "distancia" added
- [x] Class "AccionesImplementService" -> change all getDistancia for the method "distancia"
- [x] Class "JarvisImplementService" -> distanciaRecorrida is the replace for the variable "metros"
- [x] Radar 3D added :)
- [x] Method "distancia" -> improved
- [x] Class "AccionesImplementService" -> now use a more sophisticated method for position and distance traveled
- [x] Methods "generadorApagado", "recibiendoDanos", "mostrarEstado" -> moved from JarvisImplementService to Armadura
- [x] Method "daniosEnemigos" -> moved from AccionesImplementService to Objetos
- [x] Class "Constant" -> added tips 
- [x] Method "distancia" -> improved
