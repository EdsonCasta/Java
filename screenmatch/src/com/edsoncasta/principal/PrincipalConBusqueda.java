package com.edsoncasta.principal;

import com.edsoncasta.screenmatch.excepcion.ErrorEnDuracionEnMinutosException;
import com.edsoncasta.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Escribe el nombre de la pelicula: ");
            var busqueda = scanner.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            String claveApi = "2d783b4f";
            String url = "http://www.omdbapi.com/?t=" + busqueda.replace(" ", "+") + "&apikey=" + claveApi;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);
                Titulo miTitulo =  new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

                titulos.add(miTitulo);

            } catch (NumberFormatException error){
                System.out.println("Ocurrio un error: ");
                System.out.println(error.getMessage());
            } catch (IllegalArgumentException error){
                System.out.println("Error en la URI, Verifique la dirección.");
            } catch (ErrorEnDuracionEnMinutosException error){
                System.out.println(error.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        System.out.println("Finalizo la ejecucion del programa!");
    }
}
