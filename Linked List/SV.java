public class SV {
  private String name, birthday;

  public SV(String name, String birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  public String getName() {
    return this.name;
  }
  @Override
  public String toString() {
    return name + " " + birthday;
  }

}