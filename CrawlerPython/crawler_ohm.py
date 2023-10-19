from json import loads
from time import sleep
from urllib3 import PoolManager
import mysql.connector
import os
import platform
import showText

showText.mostrarTexto()

def conversor(valor):
    return float(valor[0:4].replace(",", '.'))

with PoolManager() as pool:
    while True:
        response = pool.request('GET', 'http://localhost:9000/data.json')
        data = loads(response.data.decode('utf-8'))
        temp_value = data['Children'][0]['Children'][1]['Children'][1]['Children'][0]['Value']
        ram_value = data['Children'][0]['Children'][2]['Children'][1]['Children'][0]['Value']
        disk_value = data['Children'][0]['Children'][4]['Children'][0]['Children'][0]['Value']

        systemClear = ('clear' if platform.system() == 'Linux' else 'cls')
        os.system(systemClear)
        
        print(f"""
        @====================================================@
        |                                                    |
        |           Temperatura atual: {temp_value}               |
        |           Ram atual: {ram_value}                        |
        |           Disco usado: {disk_value}                      |
        |                                                    |
        @====================================================@
        """)

        temp_value = conversor(temp_value)
        ram_value = conversor(ram_value)
        disk_value = conversor(disk_value)

        insert = f"INSERT INTO Registros (dataHora, temp_value, ram_value, disk_value) VALUES (now(), {temp_value},{ram_value}, {disk_value});"

        connection = mysql.connector.connect(
            host='localhost',
            database='Crawler',
            user='ScrapUser',
            password='Scrap2023'
        )

        try:
            cursor = connection.cursor()
            cursor.execute(insert)

            #if connection.is_connected():
            #    print("Conexão ao MySQL estabelecida.")

        except mysql.connector.Error as err:
            print(f"Erro ao conectar ao MySQL: {err}")
        finally:
            connection.commit()
            cursor.close()
            #print("Conexão ao MySQL encerrada.")

        sleep(2)