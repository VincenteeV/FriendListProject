import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
    class FriendList {
        private ArrayList<String> mainList = new ArrayList<String>();
        private ArrayList<String> bestList = new ArrayList<String>();

        public FriendList () {}

        public void makeList(String finish) {
            String input = "";
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Hello, please enter your friends' first names. Enter \"" + finish + "\" when you are done.");

            input = keyboard.next();
            while(!input.equals(finish)) {
                this.mainList.add(input);
                input = keyboard.next();
            }
        }

        public void printList() {
            System.out.println("\nYou have entered " + mainList.size() + " names.");

            for(int i = 0; i < mainList.size(); i++) {
                System.out.println((i + 1) + ". " + mainList.get(i));
            }
        }
        public void goToMovies() {
            Random rand = new Random();
            System.out.println("\nThe two friends that have been randomly chosen to go to the movies with you are: ");

            int firstFriend = rand.nextInt(mainList.size());
            System.out.println(mainList.get(firstFriend));

            int secondFriend = rand.nextInt(mainList.size());
            while (firstFriend == secondFriend) {
                secondFriend = rand.nextInt(mainList.size());
            }
            System.out.println(mainList.get(secondFriend));
        }
        public void moveToBestFriends() {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("\nWhich friends would you like to take off your friends list and add to your best friends list? Indicate with the number next to their name. Enter \"0\" to end.");

            int selection = keyboard.nextInt();
            while(selection != 0) {
                bestList.add(mainList.get(selection - 1));
                mainList.set(selection - 1, "");
                selection = keyboard.nextInt();
            }
            for (int i = mainList.size() - 1; i >= 0; i--) {
                if (mainList.get(i).equals("")) {
                    mainList.remove(i);
                }
            }

            System.out.println("\nHere is your list of friends: ");
            for(int i = 0; i < mainList.size(); i++) {
                System.out.println((i + 1) + ". " + mainList.get(i));
            }

            System.out.println("\nHere is your list of best friends: ");
            for(int i = 0; i < bestList.size(); i++) {
                System.out.println((i + 1) + ". " + bestList.get(i));
            }
        }
        public ArrayList<String> getMainList() {
            return this.mainList;
        }
        public ArrayList<String> getBestList() {
            return this.bestList;
        }
    }
