public class Task4 {

    public static <T> void swap(T[] data, int i1, int i2) {
        T t = data[i1];
        data[i1] = data[i2];
        data[i2] = t;
    }

    public static <T extends Comparable<T>> void sort(T[] data, boolean[] fixed) {
        for (int j = 1; j < data.length; ++j) {
            boolean moved = false;
            for (int i = 0; i < data.length - j; ++i) {
                // если текущий элемент нельзя менять, то идем дальше
                if (!fixed[i]) {
                    // ищем следующий элемент, который можно менять
                    int k = i + 1; // обычный случай - элемент сразу после текущего
                    // пропускаем все неизменяемые элементы
                    while (k < data.length - j + 1 && fixed[k]) {
                        ++k;
                    }

                    // если там остался изменяемый элемент и он меньше текущего,
                    // то меняем их местами
                    if (k < data.length - j + 1 && data[i].compareTo(data[k]) > 0) {
                        swap(data, i, k);
                        moved = true;
                    }
                }
            }
            if (!moved) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{7, 10, 3, 8, 4, 2};
        boolean[] fixed = new boolean[]{false, true, false, false, true, false};

        sort(data, fixed);

        for (Integer i : data) {

            System.out.print(i + " ");
        }

        System.out.println();
    }
}
