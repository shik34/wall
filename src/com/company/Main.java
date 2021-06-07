package com.company;

import java.util.Scanner;

public class Main {
    public static int[][] pole = new int[9][9];
    public static int x2 = 4, y2 = 4, wall = 1;
    public static boolean t = false;
    public static Scanner sc = new Scanner(System.in);

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
        while (t == false) {
            if (n == 1 && (pole[x2][y2 - 1]) == 0) {//вверх
                pole[x2][y2] = 0;
                y2 = y2 - 1;
                pole[x2][y2] = 2;
                t = true;
            }

            if (n == 2 && (pole[x2 + 1][y2]) == 0) {//вправо
                pole[x2][y2] = 0;
                x2 = x2 + 1;
                pole[x2][y2] = 2;
                t = true;
            }

            if (n == 3 && (pole[x2][y2 + 1]) == 0) {//вниз
                pole[x2][y2] = 0;
                y2 = y2 + 1;
                pole[x2][y2] = 2;
                t = true;
            }

            if (n == 4 && (pole[x2 - 1][y2]) == 0) {//влево
                pole[x2][y2] = 0;
                x2 = x2 - 1;
                pole[x2][y2] = 2;
                t = true;
            }
            if (t == false) {
                System.out.println("стенка");
                System.out.println("Выберите другое направление");
                pl2_hode(sc.nextInt());
                t=true;
            }
        }

    }

    public static void pl1_hode(int x1, int y1) {
        if (pole[x1][y1] == 1 || pole[x1][y1] == 2) {
            System.out.println("Вы не можете сюда походить, введите координаты повторно");
            pl1_hode(sc.nextInt(), sc.nextInt());
        } else {
            pole[x1][y1] = 1;
        }

    }

    public static void clean() {
        for (int i = 0; i < pole.length; i++) {
            for (int j = 0; j < pole.length; j++) {
                if (pole[j][i] != 1 && pole[j][i] != 2) {
                    pole[j][i] = 0;
                }
            }
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


    public static void help() {
        System.out.println("Управление кота:");
        System.out.println("1-вверх     2-вправо     3-вниз      4-влево");
        System.out.println("Управление Стенкими:");
        System.out.println("Вводите координаты постановик стены, но точка отсчета с левой верхней ячейки");
        System.out.println("(Счет с нуля)");
    }


    public static void main(String[] args) {

        boolean t1 = false;
        pole[x2][y2] = 2;

        System.out.println("Обьяснить управление?(1-да, 2-нет)");
        if (sc.nextInt() == 1) {
            help();
        } else {
            System.out.println("Хорошей игры!");
        }
        try {
            while (t1 == false) {
                System.out.println("Ход кота");
                System.out.println("Выберите направление");
                pl2_hode(sc.nextInt());
                out();
                System.out.println("Ход стенки");
                System.out.println("Введите координату");
                pl1_hode(sc.nextInt(), sc.nextInt());
                cikl();
                find12();
                t1 = proverka(x2, y2);
                clean();
                out();
            }
        } catch (Exception e) {
            System.out.println("Кот сбежал");
        }
        if (t1 == true) {
            System.out.println("Кот в клетке");
        }

    }
}
