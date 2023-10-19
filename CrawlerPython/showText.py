import os
import platform
from time import sleep

consoleColors = {
    "black": "\u001b[30m",
    "red": "\u001b[31m",
    "green": "\u001b[32m",
    "yellow": "\u001b[33m",
    "blue": "\u001b[34m",
    "magenta": "\u001b[35m",
    "cyan": "\u001b[36m",
    "white": "\u001b[37m",
    "brightBlack": "\u001b[30;1m",
    "brightRed": "\u001b[31;1m",
    "brightGreen": "\u001b[32;1m",
    "brightYellow": "\u001b[33;1m",
    "brightBlue": "\u001b[34;1m",
    "brightMagenta": "\u001b[35;1m",
    "brightCyan": "\u001b[36;1m",
    "brightWhite": "\u001b[37;1m",
    "reset": "\u001b[0m",
}

def mostrarTexto():
    print(f"""{consoleColors['cyan']}
        ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗
        ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝
        ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  
        ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  
        ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗
         ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝
    """)

    sleep(2)
    systemClear = ('clear' if platform.system() == 'Linux' else 'cls')
    os.system(systemClear)
        
    print(f"""{consoleColors['cyan']}
                             ████████╗ ██████╗ 
                             ╚══██╔══╝██╔═══██╗
                                ██║   ██║   ██║
                                ██║   ██║   ██║
                                ██║   ╚██████╔╝
                                ╚═╝    ╚═════╝ 
    """)

    sleep(2)
    systemClear = ('clear' if platform.system() == 'Linux' else 'cls')
    os.system(systemClear)
        

    print(f"""{consoleColors['magenta']} 
         ██████╗██████╗  █████╗ ██╗    ██╗██╗     ███████╗██████╗ 
        ██╔════╝██╔══██╗██╔══██╗██║    ██║██║     ██╔════╝██╔══██╗
        ██║     ██████╔╝███████║██║ █╗ ██║██║     █████╗  ██████╔╝
        ██║     ██╔══██╗██╔══██║██║███╗██║██║     ██╔══╝  ██╔══██╗
        ╚██████╗██║  ██║██║  ██║╚███╔███╔╝███████╗███████╗██║  ██║
         ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚══╝╚══╝ ╚══════╝╚══════╝╚═╝  ╚═╝ 
    """)

    sleep(3)
    systemClear = ('clear' if platform.system() == 'Linux' else 'cls')
    os.system(systemClear)

