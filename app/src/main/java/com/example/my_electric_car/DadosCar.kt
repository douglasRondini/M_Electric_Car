package com.example.my_electric_car

import model.InfoCar

data class DadosCar (
    val list: List<InfoCar> = listOf(
        InfoCar(
            foto = R.drawable.eletric_car_2,
            preço = "R$ 43.000,00",
            bateria = " 93,4 kWh",
            potencia = "140 cv",
            recarga = "23 min"
        ),
        InfoCar(
            foto = R.drawable.mercedes,
            preço = "R$ 43.000,00",
            bateria = " 93,4 kWh",
            potencia = "140 cv",
            recarga = "23 min"
        ),
        InfoCar(
            foto = R.drawable.mercedes_2,
            preço = "R$ 43.000,00",
            bateria = " 93,4 kWh",
            potencia = "140 cv",
            recarga = "23 min"
        ),
        InfoCar(
            foto = R.drawable.camaro,
            preço = "R$ 43.000,00",
            bateria = " 93,4 kWh",
            potencia = "140 cv",
            recarga = "23 min"
        ),
    )
)


