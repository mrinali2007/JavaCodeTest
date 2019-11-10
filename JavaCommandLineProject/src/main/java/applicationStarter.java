import java.util.Scanner;
import org.json.simple.JSONObject;

public class applicationStarter {

  public static void main(String[] args) throws Exception {

    UserDetailsService service = new UserDetailsService();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the operation to perform from below list ");
    JSONObject response = new JSONObject();

    while (true) {
      System.out.println("Enter the operation to perform from below list ");
      System.out.println(
          "1. Add Person (id, firstName, surname)\n2. Edit Person (firstName, surname)\n3.Delete Person (id)\n"
              + "4. Count Number of Persons\n5. List Persons\n6. Exit");
      int option = scanner.nextInt();
      switch (option) {
        case 1:
          System.out.println("Enter the person details in this format <id, firstName, surname>");
          String user = scanner.next();
          response = service.addPerson(user);
          if (response != null)
            System.out.println(response.get("message"));
          break;
        case 2:
          System.out.println("Enter the userId to edit");
          int userId = scanner.nextInt();
          String userDetails = "";
          String firstname = "", lastname = "";
          System.out.println("What do you want to edit\n1.Firstname\n2.Lastname");
          int op = scanner.nextInt();
          if (op == 1) {
            System.out.println("Enter the new firstname");
            firstname = scanner.next();
            userDetails = userDetails + "{\"firstName\":\"" + firstname + "\"}";
          } else if (op == 2) {
            System.out.println("Enter the new lastname");
            lastname = scanner.next();
            userDetails = userDetails + "{\"lastName\":\"" + lastname + "\"}";

          }
          response = service.editPerson(userId, userDetails);
          System.out.println();
          if (response != null)
            System.out.println(response.get("message"));
          System.out.println();
          break;
        case 3:
          System.out.print("Enter the userId to delete");
          int Id = scanner.nextInt();
          response = service.deletePerson(Id);
          System.out.println();
          if (response != null)
            System.out.println(response.get("message"));
          System.out.println();
          break;
        case 4:
          response = service.personCount();
          System.out.println();
          if (response != null)
            System.out.println("Number of persons present are : " + response.get("result"));
          System.out.println();
          break;
        case 5:
          response = service.getPersonsList();
          System.out.println();
          if (response != null) {
            System.out.println(response.get("message"));
            System.out.println("List of person is as below");
            System.out.println(response.get("personList"));
          }
          System.out.println();
          break;
        case 6:
          scanner.close();
          System.exit(0);
      }
    }


  }

}
