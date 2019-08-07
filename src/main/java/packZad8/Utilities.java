package packZad8;

import packZad8.packResponse.DaneApi;

import java.util.ArrayList;
import java.util.List;

public class Utilities {
    public void printList(List<DaneApi> list) {
        System.out.println();
        System.out.println("Wszystkie posty:");
        System.out.println();
        final int[] number = new int[] {1};
        for (int i = 0; i < list.size(); i++) {
            System.out.println(number[0] + ". " + list.get(i));
            number[0]++;
        }
    }

    public void mainWork(List<DaneApi> list) {
        ScannerWork scannerWork = new ScannerWork();
        System.out.println();
        System.out.println("Wybierz:\n a) wydruk wszystkich postów" +
                "\n b) wydruk postów użytkownika o userId:" +
                "\n w) koniec");
        System.out.println();
        boolean flag = false;
        do {
            char znak = scannerWork.getChar();
            switch (znak) {
                case 'a':
                    printList(list);
                    break;
                case 'b':
                    int userId = scannerWork.getInt(1, 100);
                    List<DaneApi> userIdList = getFilteredList(list, userId);
                    printList(userIdList);
                    break;
                case 'w':
                    flag = true;
                    break;
            }
        } while (!flag);
    }

    public List<DaneApi> getFilteredList(List<DaneApi> list, int userId) {
        List<DaneApi> filtredList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUserId() == userId) {
                filtredList.add(list.get(i));
            }
        }
//        List<DaneApi> filtredList = list.stream()
//                .filter(daneApi -> daneApi.getUserId() == userId)
//                .collect(Collectors.toList());
        return filtredList;
    }


}
