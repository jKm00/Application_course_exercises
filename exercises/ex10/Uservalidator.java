public class Uservalidator {
  public static void main(String[] args) {
    Uservalidator userValidator = new Uservalidator();
    String[] usernames = {"8", "Julia", "Samantha", "Samantha_21", "1Samantha", "Samantha?10_2A", "JuliaZ007", "Julia@007", "_Julia007"};
    userValidator.checkList(usernames);
  }

  /**
   * Checks if a username is valid.
   * A username is only valid if:
   * - It is between 8 and 30 characters long
   * - Only contains alphanumeric characters and underscores
   * - The first letter has to be an alphabetic character
   * @param username the username to be validated
   * @return {@code true} if username is valid, {@code false} otherwise
   */
  private boolean validateUsername(String username) {
    return (username.matches("^[a-zA-Z0-9_]{8,30}$") && username.substring(0, 1).matches("^[a-zA-Z]*$"));
  }

  /**
   * Validates a list of username, where the first element is the number of usernames
   * @param usernames a list of usernames
   */
  private void checkList(String[] usernames) {
    int numberOfUsername = Integer.parseInt(usernames[0]);
    int i = 1;
    while (i <= numberOfUsername) {
      if (this.validateUsername(usernames[i])) {
        System.out.println(usernames[i] + ": Valid");
      } else {
        System.out.println(usernames[i] + ": Invalid");
      }
      i++;
    }
  }
}