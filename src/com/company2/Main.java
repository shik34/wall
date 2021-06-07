package com.company2;



import java.util.Scanner;

public class Main {
    public static int[][] pole = new int[9][9];
    public static int x2 = 4, y2 = 4, wall = 1;
    public static boolean t = false;
    public Scanner sc = new Scanner(System.in);

    public static void out() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                System.out.print(pole[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void pl2_hode(int n) {
        boolean t = false;
        while (t == true) {
            if (n == 1 && (pole[x2][y2 - 1]) == 0) {//вверх
                pole[x2][y2] = 0;
                y2 = y2 - 2;
                pole[x2][y2] = 2;
                t = true;
            }

            if (n == 2 && (pole[x2 + 1][y2]) == 0) {//вправо
                pole[x2][y2] = 0;
                x2 = x2 + 2;
                pole[x2][y2] = 2;
                t = true;
            }

            if (n == 3 && (pole[x2][y2 + 1]) == 0) {//вниз
                pole[x2][y2] = 0;
                y2 = y2 + 2;
                pole[x2][y2] = 2;
                t = true;
            }

            if (n == 4 && (pole[x2 - 1][y2]) == 0) {//влево
                pole[x2][y2] = 0;
                x2 = x2 - 2;
                pole[x2][y2] = 2;
                t = true;
            }
            if (t == false) {
                System.out.println("стенка");
            }
        }

    }

    public static void pl1_hode(int x1, int y1, int side, boolean end_hode) {


        Scanner sc = new Scanner(System.in);
        while (wall != 0 && end_hode == false) {

            if (side == 1) {//поставить стенку вверх
                if (pole[x1 * 2 - 1][y1 * 2 - 1 - 1] == 1) {
                    System.out.println("Стенка уже поставлена");
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    side = sc.nextInt();

                } else {
                    pole[x1 * 2 - 1][y1 * 2 - 1 - 1] = 1;
                    wall = wall - 1;
                    if (wall > 0) {
                        System.out.println("Конец хода?");
                        end_hode = sc.nextBoolean();
                    }
                }

            }
            if (side == 2) {//поставить стенку вправо
                if (pole[x1 * 2 - 1 + 1][y1 * 2 - 1] == 1) {
                    System.out.println("Стенка уже поставлена");
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    side = sc.nextInt();

                } else {
                    pole[x1 * 2 - 1 + 1][y1 * 2 - 1] = 1;
                    if (wall > 0) {
                        System.out.println("Конец хода?");
                        end_hode = sc.nextBoolean();
                    }
                }

            }
            if (side == 3) {//поставить стенку вниз
                if (pole[x1 * 2 - 1][y1 * 2 - 1 + 1] == 1) {
                    System.out.println("Стенка уже поставлена");
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    side = sc.nextInt();

                } else {
                    pole[x1 * 2 - 1][y1 * 2 - 1 + 1] = 1;
                    if (wall > 0) {
                        System.out.println("Конец хода?");
                        end_hode = sc.nextBoolean();
                    }
                }
            }
            if (side == 4) {//поставить стенку влево
                if (pole[x1 * 2 - 1 - 1][y1 * 2 - 1] == 1) {
                    System.out.println("Стенка уже поставлена");
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    side = sc.nextInt();

                } else {
                    pole[x1 * 2 - 1 - 1][y1 * 2 - 1] = 1;
                    if (wall > 0) {
                        System.out.println("Конец хода?");
                        end_hode = sc.nextBoolean();
                    }

                }
            }

        }
        if (wall + 1 != 4) {
            wall = wall + 1;
        }


    }

    public static void cikl() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] == 1) {
                    zap(j, i);
                }
            }
        }
    }

    public static void zap(int x, int y) {
        int x1 = x, y1 = y;
        try {
            while (pole[x][y - 1] != 1) {
                if (pole[x][y - 1] == 2) {
                    y = y - 1;
                }
                y = y - 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x][y + 1] != 1) {
                if (pole[x][y + 1] == 2) {
                    y = y + 1;
                }
                y = y + 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }


            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x - 1][y] != 1) {
                if (pole[x - 1][y] == 2) {
                    x = x - 1;
                }
                x = x - 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x + 1][y] != 1) {
                if (pole[x + 1][y] == 2) {
                    x = x + 1;
                }
                x = x + 1;
                if (pole[x][y] != 1) {
                    pole[x][y] = pole[x][y] + 3;
                }
            }
        } catch (Exception e) {
        }

    }

    public static boolean proverka(int x, int y) {
        int x1 = x, y1 = y;
        boolean t = true;
        try {
            while (pole[x][y - 1] != 1) {
                y = y - 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x][y + 1] != 1) {
                y = y + 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x - 1][y] != 1) {
                x = x - 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }
        x = x1;
        y = y1;
        try {
            while (pole[x + 1][y] != 1) {
                x = x + 1;
                if (pole[x][y] != 12 || pole[x][y] == 1) {
                    t = false;
                }
            }
        } catch (Exception e) {
        }


        return t;
    }

    public static void find12() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] == 12) {
                    rec(j, i);


                }
            }
        }
    }

    public static void rec(int x, int y) {
        if (pole[x + 1][y] != 12 && pole[x + 1][y] != 1 && pole[x + 1][y] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x][y + 1] != 12 && pole[x][y + 1] != 1 && pole[x][y + 1] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x - 1][y] != 12 && pole[x - 1][y] != 1 && pole[x - 1][y] != 2) {
            pole[x][y] = 0;
        }
        if (pole[x][y - 1] != 12 && pole[x][y - 1] != 1 && pole[x][y - 1] != 2) {
            pole[x][y] = 0;
        }


        if (pole[x][y - 1] == 12 && pole[x][y] == 0) {
            rec(x, y - 1);
        }
        if (pole[x][y + 1] == 12 && pole[x][y] == 0) {
            rec(x, y + 1);
        }
        if (pole[x + 1][y] == 12 && pole[x][y] == 0) {
            rec(x + 1, y);
        }
        if (pole[x - 1][y] == 12 && pole[x][y] == 0) {
            rec(x - 1, y);
        }


    }


    public static void main(String[] args) {

        boolean t1;
        pole[x2][y2] = 2;
        pole[3][2] = 1;
        pole[4][2] = 1;
        pole[5][2] = 1;

        pole[6][3] = 1;
        pole[6][4] = 1;
        pole[6][5] = 1;

        pole[5][6] = 1;
        pole[4][6] = 1;
        pole[3][6] = 1;

        pole[2][5] = 1;
        pole[0][4] = 1;
        pole[2][3] = 1;

        cikl();
        find12();
        out();
        System.out.println(t);
        t1 = proverka(x2, y2);
        if (t1 == false) {
            System.out.println("Игрок не в клетке");
        } else {
            System.out.println("Игрок в клетке");
        }


    }
}
