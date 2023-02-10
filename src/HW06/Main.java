package HW06;
//Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
//        Создать множество ноутбуков.
//        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
//        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
//        ----------------------Критерии оценивания---------------------------
//        Оценка “Отлично” ставится, если
//        Задание выполнено в полном объеме, допустимы некритичные замечания по оформлению кода, выбору полей и методов, структур для хранения.
//        Оценка “Хорошо” ставится, если Задания 3, 4 или 5 выполнены не в полном объеме, либо есть грубые ошибки в проектировании или реализации методов.
//        Оценка “Удовлетворительно” выставляется, если верно выполнены только задания 1 и 2. Возможна неудачная попытка выполнить оставшиеся пункты.
//        Оценка “Не сдано” выставляется, если прислан пустой файл, битая ссылка, нерелевантно содержимое присланного.

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Set<Notebook> inStock = new HashSet<>();

    static List<String> oSys = new LinkedList<>(List.of(
            "Windows 10 Home", "Windows 10 Pro", "Windows 10 Ultra",
            "Windows 11 Home", "Windows 11 Pro", "Windows 11 Ultra"));
    static List<String> brandNames = new ArrayList<>(List.of(
            "Acer", "Samsung", "Dell", "Asus",
            "Hewlett-Packard", "Xiaomi", "BQ"));
    static List<Integer> romVolume = new ArrayList<>(List.of(4, 8, 16, 32));
    static List<Integer> hddVolume = new ArrayList<>(List.of(256, 512, 1024, 2048));
    static List<Integer> screenSize = new ArrayList<>(List.of(13, 14, 15, 17, 19));
    static List<String> screenResolution = new ArrayList<>(List.of("HD", "FullHD", "UHD", "4K", "8K"));

    public static void main(String[] args) {
//        Формируем множество ноутбуков из рандомных наборов
        addNotebooksToStock();

//        Запрашиваем у пользователя фильтры поиска
        Map<String, String> searchQuery = QueryFromUser();
        System.out.println("Заданы следующие фильтры поиска:\n" + searchQuery);

//        Выдаем результат поиска
        System.out.println("Вот что нашлось по указанным фильтрам:");
        System.out.println(filterNotebooks(inStock, searchQuery));

    }

    private static Set<Notebook> filterNotebooks(Set<Notebook> inStock, Map<String, String> searchQuery) {
        var filteredNotebooks = new HashSet<>(inStock);
        for (Notebook notebook : inStock) {
            for (String filter :
                    searchQuery.keySet()) {
                if (!notebook.getProperties().contains(searchQuery.get(filter))) {
                    filteredNotebooks.remove(notebook);
                    break;
                }
            }
        }
        return filteredNotebooks;
    }

    /**
     * Автоматическое формирование "ассортимента" ноутбуков
     */
    private static void addNotebooksToStock() {
        Random random = new Random();

//        Моделирование характеристик очередного ноутбука и добавление его во множество
        for (int i = 0; i < 500; i++) {
            String brand = brandNames.get(random.nextInt(brandNames.size()));
            String os = oSys.get(random.nextInt(oSys.size()));
            String model = "model" + random.nextInt(1000);
            int rom = romVolume.get(random.nextInt(romVolume.size()));
            int hdd = hddVolume.get(random.nextInt(hddVolume.size()));
            int screen = screenSize.get(random.nextInt(screenSize.size()));
            String resolution = screenResolution.get(random.nextInt(screenResolution.size()));
            String target;
            if (rom >= 16 && hdd >= 1024 & screen > 15) target = "для игр и программирования";
            else if (rom < 8) target = "для офиса";
            else target = "для дома";

            inStock.add(new Notebook(os, brand, model, rom, hdd, screen, resolution, target));
        }
    }

    /**
     * Возвращает сформированный пользователем набор фильтров поиска
     *
     * @return HashMap<фильтр, значение>
     */
    private static Map<String, String> QueryFromUser() {
        Map<String, String> query = new LinkedHashMap<>();

        System.out.print("""
                Введите через запятую фильтры поиска или "все" для вывода полного ассортимента ноутбуков:
                1 - производитель (бренд)
                2 - Операционная система
                3 - Объем жесткого диска (HDD)
                4 - объем оперативной памяти (ROM)
                5 - размер экрана по диагонали в дюймах
                6 - разрешение экрана (HD, FullHD, UHD, 4K)
                7 - Рекомендуемое применение - для офиса, для дома, для игр и программирования
                >>>""");
        String input = scanner.nextLine();
        String[] digits = input.replaceAll(" ", "").split(",");

        for (String digit : digits) {
            switch (digit) {
                case "1" -> query.put("brand", chooseBrand());
                case "2" -> query.put("os", chooseOS());
                case "3" -> query.put("hdd", chooseHdd());
                case "4" -> query.put("rom", chooseROM());
                case "5" -> query.put("screen", chooseScreen());
                case "6" -> query.put("resolution", chooseResolution());
                case "7" -> query.put("target", chooseTarget());
                case "все" -> System.out.println(inStock);
            }
        }
        return query;
    }


    //    Методы для выбора конкретных значений фильтров
    private static String chooseTarget() {
        System.out.println("""
                Выберите назначение ноутбука:
                1 - для офиса
                2 - для дома
                3 - для игр и программирования""");
        switch (scanner.nextLine()) {
            case "1" -> {
                return "для офиса";
            }
            case "2" -> {
                return "для дома";
            }
            case "3" -> {
                return "для игр и программирования";
            }
        }
        return null;
    }

    private static String chooseResolution() {
        System.out.printf("""
                Выберите разрешение экрана: %s
                >>>""", screenResolution);
        return scanner.nextLine();
    }

    private static String chooseScreen() {
        System.out.printf("""
                Выберите размер экрана по диагонали в дюймах: %s
                >>>""", screenSize);
        return scanner.nextLine();
    }

    private static String chooseROM() {
        System.out.printf("""
                Выберите объем оперативной памяти:
                %s
                >>>""", romVolume);
        return scanner.nextLine();
    }

    private static String chooseHdd() {
        System.out.printf("""
                Выберите объем жесткого диска (HDD):
                %s
                >>>""", hddVolume);
        return scanner.nextLine();
    }

    private static String chooseOS() {
        System.out.println("Выберите операционную систему:");
        for (String os : oSys)
            System.out.printf("%d - %s\n", oSys.indexOf(os), os);
        return oSys.get(Integer.parseInt(scanner.nextLine()));
    }

    private static String chooseBrand() {
        System.out.printf("""
                Выберите производителя:
                %s
                >>>""", brandNames);
        return scanner.nextLine();
    }
}