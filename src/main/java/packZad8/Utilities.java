package packZad8;

import packZad8.packResponse.DaneApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utilities {
    public void printList(List<Map<String,String>> list) {
        System.out.println();
        System.out.println("Wszystkie posty:");
        System.out.println();
        final int[] number = new int[] {1};
        for (int i = 0; i < list.size(); i++) {
            System.out.println(number[0] + ". " + list.get(i));
            number[0]++;
        }
    }

    public void mainWork(List<Map<String,String>> list) {
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
                    List userIdList = getFilteredList(list, userId);
                    printList(userIdList);
                    break;
                case 'w':
                    flag = true;
                    break;
            }
        } while (!flag);
    }

    public List<DaneApi> getFilteredList(List<Map<String,String>> list, int userId) {
        List<DaneApi> filtredList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            DaneApi daneApi = new DaneApi();
            daneApi.setUserId((int)Double.parseDouble(list.get(i).get("userId")));
            daneApi.setBody(list.get(i).get("body"));
            daneApi.setTitle(list.get(i).get("title"));
            daneApi.setId(Integer.parseInt(list.get(i).get("id")));
            filtredList.add(daneApi);
        }
//        List<DaneApi> filtredList = list.stream()
//                .filter(daneApi -> daneApi.getUserId() == userId)
//                .collect(Collectors.toList());
        return filtredList;
    }


}
