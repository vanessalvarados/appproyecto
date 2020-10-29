package edu.galileo.android.moviemanager.models;

import java.util.ArrayList;
import java.util.List;

public class ArticuloRepository {
    static List<Articulo> listArticulo = new ArrayList<Articulo>();

    public static void inicializarData() {
        listArticulo.removeAll(getListArticulo());
        listArticulo.add(new Articulo(
                1,
                "Tytax T1-X Home Gym ",
                "Tytax",
                "Levanta Pesas",
                90,
                "N",
                0,
                "",
                "https://i.ebayimg.com/thumbs/images/g/KAIAAOSwuShaXz9j/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/g/KAIAAOSwuShaXz9j/s-l225.jpg", 4.5));

        listArticulo.add(new Articulo(
                2,
                "Cinturón Ciclismo",
                "Nike",
                "Cinturón Ciclismo paquete de la Cintura Bolsa Bolsa Gimnasia Deportes",
                50,
                "S",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/m/mRwlrggjRM8Rxga8qiM5v1A/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/m/mRwlrggjRM8Rxga8qiM5v1A/s-l225.jpg", 3.2));

        listArticulo.add(new Articulo(
                3,
                "Running Deportes Gimnasio",
                "Samsung",
                "Running Deportes Gimnasio Armband móvil Jog Banda de Brazo Pouch Samsung Galaxy Smartphone",
                20,
                "N",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/m/mchWg7IgTtcfO6cIyGjzssw/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/m/mchWg7IgTtcfO6cIyGjzssw/s-l225.jpg", 3.2));

        listArticulo.add(new Articulo(
                4,

                "50 kg Chaleco ponderado ajustable Fitness",
                "Nike",
                "50 kg Chaleco ponderado ajustable Fitness Correr Gimnasio Chaleco Chaqueta",
                55,
                "N",
                10,
                "",
                "https://i.ebayimg.com/thumbs/images/g/l-sAAOSwiHpaMKsJ/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/g/l-sAAOSwiHpaMKsJ/s-l225.jpg", 3.2));

        listArticulo.add(new Articulo(
                5,
                "Heavy Duty Sudadera Sauna",
                "Nike",
                "Heavy Duty Sudadera Sauna Ejercicio Gimnasio Traje Fitness pérdida de peso",
                20,
                "S",
                10,
                "",
                     "https://i.ebayimg.com/thumbs/images/m/mSr6iR4GipZOsQR5euYJV5Q/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/m/mSr6iR4GipZOsQR5euYJV5Q/s-l225.jpg", 3.2));

        listArticulo.add(new Articulo(
                6,
                "Levantamiento de Pesas Gimnasio Correa",
                "RDX",

                "RDX Cuero Entrenamiento Levantamiento de Pesas Gimnasio Correa Culturismo",
                500,
                "N",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/m/mcylCHt7RHXZcTLcwN373GA/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/m/mcylCHt7RHXZcTLcwN373GA/s-l225.jpg", 3.2));


        listArticulo.add(new Articulo(
                7,
                "Fitness Gym Entrenamiento Fuerza bolsa",
                "Nike",

                "ARD Champs ™ Fitness Gym Entrenamiento Fuerza bolsa de 5 a 20 Kgs búlgaro",
                23,
                "N",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/m/mct26ziePk_qNzBFPK0F86g/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/m/mct26ziePk_qNzBFPK0F86g/s-l225.jpg", 3.2));


        listArticulo.add(new Articulo(
                8,

                "F4H",
                "RVR",
                "F4H entrenador elíptico Cruz de impulsos de Aire Bicicleta de Ejercicio Gimnasio",
                50,
                "N",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/g/rdIAAOSwDJZb5GN0/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/g/rdIAAOSwDJZb5GN0/s-l225.jpg", 3.2));

        listArticulo.add(new Articulo(
                9,
                "Deslizamiento De Acero",
                "RDX",
                "Gimnasio Casa sólido Dip Estación de prueba de deslizamiento De Acero ",
                28,
                "N",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/g/6K0AAOSwV45bnG~V/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/g/6K0AAOSwV45bnG~V/s-l225.jpg", 3.2));


        listArticulo.add(new Articulo(
                10,
                "Correa Estuche Cubierta",
                "Nike",
                "Deportes Correr Gym Para Correa Estuche Cubierta Para Nuevo iPhone XR, XS-MAX",
                15,
                "N",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/m/mS7fyFnoBXfZU8vtat5UqMw/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/m/mS7fyFnoBXfZU8vtat5UqMw/s-l225.jpg", 3.2));

        listArticulo.add(new Articulo(
                11,
                "Bolsa De Lona",
                "Tommy Hilfiger",

                "Tommy Hilfiger 2018 Nylon Camo Stripe Bolsa De Lona Bolsa De Viaje Gimnasio",
                60,
                "N",
                50,
                "",
                "https://i.ebayimg.com/thumbs/images/g/pLoAAOSw5xpbZLNc/s-l225.jpg",
                "https://i.ebayimg.com/thumbs/images/g/pLoAAOSw5xpbZLNc/s-l225.jpg", 3.2));


        listArticulo.add(new Articulo(
                12,
                "Modelador De Cintura Modelador",
                "Nike",

                "Entrenamiento Deporte Modelador De Cintura Modelador Faja Corsé Gimnasio",
                63,
                "S",
                10,
                "",
                "https://i.linio.com/p/e2c827aedab24572112e1b72874e7ab3-catalog.webp",
                "https://i.ytimg.com/vi/n0H_Q_JsboU/maxresdefault.jpg", 3.2));


    }


    public static List<Articulo> getListArticulo() {
        return listArticulo;
    }
}
