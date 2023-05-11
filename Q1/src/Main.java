import java.util.Scanner;

/**
 * This program gets a shape of a tower (rectangle or triangle) and its size and prints/calculates area/perimeter,according to the instructions given in advance.
 * I assumed the height and width of towers are Integers.
 */


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            /* getting command from user */
            System.out.println("Please choose an option:");
            System.out.println("-press 1 for rectangle building\n-press 2 for triangle building\n-press 3 for exit");
            int command = scanner.nextInt();
            int height = 0,width = 0;
            /* get width and height */
            if(command == 1 || command == 2) {
                System.out.println("Insert height and width");
                height = scanner.nextInt();
                width = scanner.nextInt();
            }

            switch (command) {
                case 1:
                    rectangle_building(height,width);
                    break;
                case 2:
                    triangle_building(height,width);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("--Command not valid--");
                    break;
            }
        }
    }

    private static void rectangle_building(int height, int width) {

        int diff = Math.abs(height - width);

        /* case square or diff greater than 5 -> print area */
        if (height == width || diff > 5) {
            int area = width * height;
            System.out.println("The rectangle area is: " + area);
        } else {
            int scope = 2 * (width + height);
            System.out.println("The rectangle scope is: " + scope);
        }
    }

    private static void triangle_building(int height, int width) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose an option:");
        System.out.println("-Press 1 to get the triangle perimeter\n-Press 2 to print the triangle");
        int command = scanner.nextInt();

        switch (command) {
            case 1:
                // Calculate the length of the hypotenuse using the Pythagorean theorem
                double halfBase = width/2.0;
                double hypotenuse = Math.sqrt(height * height + halfBase * halfBase);
                double perimeter = (2 * hypotenuse) + width;
                System.out.println("The perimeter of the triangle is " + perimeter);
                break;
            case 2:
                print_triangle(height, width);
                break;
            default:
                System.out.println("--Command not valid--");
                break;
        }
    }

    private static void print_triangle(int height, int width) {
        /* if width is odd number or width is greater than height * 2 or width < 3 --> will not be printed*/
        if (width % 2 == 0 || width > height * 2 || width < 3)
            System.out.println("Cannot print triangle");
        /* special case because all inner lines will be 3 stars */
        else if(width == 3) {
            print_stars(1, 1, 1); //first line
            print_stars(height -1,width,0); // the rest lines
        }
        else {
            int num_groups = (width - 3) / 2;// inner groups of stars
            int inner_lines = (height - 2) / num_groups;// count number of lines per group
            int top_lines = inner_lines + (height - 2) % num_groups;// more lines for top lines (division remainder)

            /* print stars */
            print_stars(1, 1,num_groups + 1); // first line
            for (int i = 1; i <= num_groups; i++) {
                if (i == 1)// first inner group with more lines(or zero)
                    print_stars(top_lines, (2 * i) + 1,num_groups + 1  - i);
                else /* the rest of inner groups*/
                    print_stars(inner_lines, (2 * i) + 1,num_groups + 1 - i);
            }
            print_stars(1, width,0);// last line
        }
    }

    private static void print_stars(int lines, int amount,int spaces) {
        /*print line of stars with spaces*/
        for (int i = 0; i < lines; i++) {
            for (int k = 0; k < spaces; k++){
                System.out.print(" ");
            }
            for (int j = 0; j < amount; j++)
                System.out.print("*");
            System.out.print("\n");// next line
        }
    }
}