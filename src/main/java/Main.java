class main {
    public static void main(String[] args) {
        // Инициализируем
        Coord[] myList = new Coord[100];
        for (int i = 0; i < 100; i++) {
            myList[i] = new Coord(0, 0, 0, false);
        }
        // Заполняем таблицу элементами
        for (int i = 0; i < 5; i++) {
            int x = (int) (Math.random() * 100);
            int y = (int) (Math.random() * 100);
            boolean exist = true;
            int col = 0;
            int k = (x + y);
            int h = hash_f(k);
            myList[h].add(myList, x, y, col, exist, h);
        }
// Вывод таблицы на экран
        System.out.println("x y Ключи");
        for (int i = 0; i < 100; i++) {
        myList[i].show(myList, i);
 }
  //Вывод коллизий
       System.out.println("\nВывод коллизий\nx y Ключ");
       for (int i = 0; i < 100; i++) {
       myList[i].get(myList, i);
 }
    }
    private static int hash_f(int k) {
        return k % 100;
    }
}


class Coord {
    public int x, y, col, k;
    public boolean exist;

    public Coord(int newX, int newY, int newCol, boolean newExist) {
        x = newX;
        y = newY;
        col = newCol;
        exist = newExist;
    }

    public void add(Coord[] point, int x, int y, int col, boolean exist, int n) {
        if (!point[n].exist) {
            point[n] = new Coord(x, y, col, exist);
        } else {
            // System.out.println("Обнаружена коллизия!");
            while (point[n].exist) {
                col++;
                n++;
                if (point[n].exist)
                    continue;
                if (n < 100 & !point[n].exist) {
                    point[n].x = x;
                    point[n].y = y;
                    point[n].exist = exist;
                    point[n].col = col;
                    break;
                }
                if (n >= 100) {
                    n = n - 100;
                }
            }
        }
    }

    public String get(Coord[] point, int n) {
        String msg = "Collision isn't exist!";
        if (point[n].col != 0) {
            int k = (point[n].x + point[n].y) % 100;
            msg = "Collision is exist!";
             System.out.println(point[(n - point[n].col)].x + " " + point[(n - point[n].col)].y + " " +k);
             System.out.println(point[n].x + " " + point[n].y + " " + k);
             System.out.println("- - -");
        }
        return msg;
    }

    public void show(Coord[] point, int n) {
        
        int r = 0;
        if (point[n].exist) {
            int k = (point[n].x + point[n].y);
            r = k + point[n].col;
            System.out.print(point[n].x + " " + point[n].y + " " + k + " " + r);
            if (k != r)
                System.out.print(" <-- Коллизия\n");
            else
                System.out.print("\n");
        }
    }
} 

