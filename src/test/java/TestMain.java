

class Testmain {
    @org.junit.jupiter.api.Test
    void CollisionExist() {
        String msg1 = "Collision is exist!";
        String msg2 = "Collision isn't exist!";
        Coord[] myList = new Coord[100];
        for (int i = 0; i < 100; i++) {
            myList[i] = new Coord(0, 0, 0, false);
        }
        myList[5].add(myList, 15, 90, 0, true, 5);
        myList[5].add(myList, 67, 38, 0, true, 5);
        myList[7].add(myList, 88, 19, 0, true, 7);
        myList[15].add(myList, 99, 16, 0, true, 15);
        myList[62].add(myList, 54, 8, 0, true, 62);
        for (int i = 0; i < 100; i++) {
            myList[i].get(myList, i);
            if (myList[i].get(myList, i) == msg1) {
                msg2 = msg1;
                break;
            }
        }
        assert (msg1 == msg2);
    }

    @org.junit.jupiter.api.Test
    void CollisionDoesNotExist() {
        String msg1 = "Collision is exist!";
        String msg2 = "Collision isn't exist!";
        Coord[] myList = new Coord[100];
        for (int i = 0; i < 100; i++) {
            myList[i] = new Coord(0, 0, 0, false);
        }
        myList[39].add(myList, 93, 46, 0, true, 39);
        myList[59].add(myList, 3, 56, 0, true, 59);
        for (int i = 0; i < 100; i++) {
            myList[i].get(myList, i);
            if (myList[i].get(myList, i) == msg2) {
                msg1 = msg2;
                break;
            }
        }
        assert (msg1 == msg2);
    }
}
