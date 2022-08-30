public class Sv {
  private String name, birthday;

  public Sv(String name, String birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name + " " + birthday;
  }
}
