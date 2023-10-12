
lugares=["-","-","-","-","-","-","-","-","-"]

ganador= None

def juego():
    global ganador
    print("Es hora de jugar!!")
    ver_tablero()
    #Se hace jugar a los participantes
    for i in range(5):
        print("Turno del jugador 1. [X]")
        valor= "X"
        jugada(valor)
        huboganador()
        #Este if controla la jugada y verifica si no hay ganadores para darle el turno al otro jugador.
        if ganador !="X" and i < 4:
            for j in range(3):
                print("Turno del jugador 2. [O]")
                valor= "O"
                jugada(valor)
                huboganador()

                if ganador=="O":
                    print("¡Felicidades!. ¡El jugador 2 ha ganado!")
                break
        elif ganador=="X":
            print("¡Felicidades!. ¡El jugador 1 ha ganado!")
            break   

        else: 
            print("¡Ha ocurrido un EMPATE!")

def jugada(valor):
 
    anoto = False
    while anoto == False:   
    
        posicion=int(input("Elija un lugar del 1 al 9"))
        posicion-= 1
        #Si la posicion es igual a guion, la posicion esta libre. 
        if lugares [posicion]=="-":
            anoto=True
        else:
            print("Posicion Ocupada,vuelva a ingresar un valor.")

        lugares[posicion] = valor
        ver_tablero()


            

def huboganador():
    global ganador
    controlLinea()
    controlVertical()
    controlDiagonal()

def controlLinea():
    global ganador
    if lugares[0]== lugares[1]== lugares[2] != "-":
        ganador=lugares[0]
    elif lugares[3]== lugares[4]== lugares[5] != "-":
        ganador=lugares[3]
    elif lugares[6]== lugares[7]== lugares[8] != "-":
        ganador=lugares[8]

def controlVertical():
    global ganador
    if lugares[0]== lugares[3]== lugares[6] != "-":
        ganador=lugares[0]
    elif lugares[1]== lugares[4]== lugares[7] != "-":
        ganador=lugares[1]
    elif lugares[2]== lugares[5]== lugares[8] != "-":
        ganador=lugares[2]

def controlDiagonal():
    global ganador   
    if lugares[0]== lugares[4]== lugares[8] != "-":
        ganador=lugares[0]
    elif lugares[2]== lugares[4]== lugares[6] != "-":
        ganador=lugares[2]



def ver_tablero():
    print("\n")
    print("|"+lugares[0]+"|"+lugares[1]+"|"+lugares[2]+"|") 
    print("|"+lugares[3]+"|"+lugares[4]+"|"+lugares[5]+"|")
    print("|"+lugares[6]+"|"+lugares[7]+"|"+lugares[8]+"|")
    print("\n")

