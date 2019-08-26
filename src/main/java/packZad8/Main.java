package packZad8;

import packZad8.packResponse.DaneApi;
import packZad8.packResponse.JSONwork;

import java.util.ArrayList;
import java.util.List;

/*
Napisz aplikację pobierającą z adresu: https://jsonplaceholder.typicode.com/posts dane.
Aplikacja powinna obsługiwać komendy:

wypisz wszystkie - komenda wypisuje wszystkie posty
wypisz wszystkie 4 - komenda wypisuje wszystkie posty użytkownika o identyfikatorze 4

** niech klasa odpowiadająca za ładowanie wyników będzie singletonem

 */
public class Main {
    public static void main(String[] args) {
        System.out.println();
        Utilities utilities = new Utilities();

        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONwork jsoNwork = new JSONwork();
        List list = jsoNwork.loadDataByStream(url);
//        List<DaneApi> list = jsoNwork.loadURLbyString(url);
        utilities.mainWork(list);
//        utilities.printList(list);

        // dlaczego na wydruku userId oraz id to double?
        // dlaczego poniżej list.forEach(System.out::println) nie działa a w Utilities.printList fori działa dla tej samej listy?
        // działa
        System.out.println();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(list.get(i).getUserId());
//        }

        // nie działa?
        List<DaneApi> filtredList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getUserId() == 1) {
//                filtredList.add(list.get(i));
//            }
//        }

        System.out.println(filtredList.size());

        // nie działa (ani dla 1 ani dla 1.0)
//        list.stream()
//                .filter(daneApi -> daneApi.getUserId() == 1)
//                .forEach(daneApi -> System.out.println(daneApi));

//        list.forEach(System.out::println);
    }
}
